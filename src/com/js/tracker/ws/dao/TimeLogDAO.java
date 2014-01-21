package com.js.tracker.ws.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.js.db.MyConnection;
import com.js.tracker.ws.dto.LoginDTO;
import com.js.tracker.ws.dto.SearchDTO;
import com.js.tracker.ws.dto.SearchResultDTO;
import com.js.tracker.ws.dto.TimeLogDTO;
import com.js.tracker.ws.dto.UserDateWiseDTO;
import com.js.tracker.ws.util.TrackerDate;

public class TimeLogDAO {

	public String changeManualstatus(TimeLogDTO dto) throws Exception{
		String ret = "error";
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			con.setAutoCommit(false);
			String query = "update tbl_tracker_manual_timelog set m_entry_status=? where username =? and c_date=? and start_time=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dto.getM_entry_status());
			ps.setString(2, dto.getUsername());
			ps.setString(3, dto.getC_date());
			ps.setString(4, dto.getStart_time());
			ps.executeUpdate();
			ps.close();
			if(dto.getM_entry_status().equalsIgnoreCase("approve")){
				query = "insert into tbl_tracker_timelog(username,c_date,start_time,end_time,m_entry_status) values (?,?,?,?,?)";
				ps = con.prepareStatement(query);
				ps.setString(1, dto.getUsername());
				ps.setString(2, dto.getC_date());
				ps.setString(3, dto.getStart_time());
				ps.setString(4, dto.getEnd_time());
				ps.setString(5, dto.getM_entry_status());
				ps.executeUpdate();
				ps.close();
			}			
			
			con.commit();
			ret="success";
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			con.close();
		}
		return ret;
	}

	public List<TimeLogDTO> getUserTimeLog(LoginDTO dto) throws Exception {
		List<TimeLogDTO> list = new ArrayList<TimeLogDTO>();
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			String query = "select * from tbl_tracker_timelog where username =?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dto.getUnm());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TimeLogDTO tlogin = new TimeLogDTO();
				tlogin.setC_date(rs.getString("c_date"));
				tlogin.setEnd_time(rs.getString("end_time"));
				tlogin.setStart_time(rs.getString("start_time"));
				tlogin.setUsername(rs.getString("username"));
				tlogin.setM_entry_reason("");
				tlogin.setM_entry_status(rs.getString("m_entry_status"));
				if(tlogin.getM_entry_status().equalsIgnoreCase("implicit")){
					tlogin.setLog_type("auto");	
				}else{
					tlogin.setLog_type("manual");
				}
				
				list.add(tlogin);
			}
			rs.close();
			ps.close();

			query = "select * from tbl_tracker_manual_timelog where username =?";
			ps = con.prepareStatement(query);
			ps.setString(1, dto.getUnm());
			rs = ps.executeQuery();
			while (rs.next()) {
				TimeLogDTO tlogin = new TimeLogDTO();
				tlogin.setC_date(rs.getString("c_date"));
				tlogin.setEnd_time(rs.getString("end_time"));
				tlogin.setStart_time(rs.getString("start_time"));
				tlogin.setUsername(rs.getString("username"));
				tlogin.setM_entry_reason(rs.getString("m_entry_reson"));
				tlogin.setM_entry_status(rs.getString("m_entry_status"));
				tlogin.setLog_type("manual");
				list.add(tlogin);
			}
			rs.close();
			ps.close();

		} finally {
			con.close();
		}
		return list;
	}

	private TimeLogDTO checkTimeLog(TimeLogDTO dto, Connection con)
			throws Exception {
		TimeLogDTO newDto = null;
		try {
			String query = "select * from tbl_tracker_timelog where username =? and c_date=? and start_time=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dto.getUsername());
			ps.setString(2, dto.getC_date());
			ps.setString(3, dto.getStart_time());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				newDto = new TimeLogDTO();
				newDto.setUsername(rs.getString("username"));
			}
			rs.close();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newDto;
	}

	private TimeLogDTO checkManualTimeLog(TimeLogDTO dto, Connection con)
			throws Exception {
		TimeLogDTO newDto = null;
		try {

			String query = "SELECT * FROM tbl_tracker_timelog where username='"
					+ dto.getUsername() + "' and c_date='" + dto.getC_date()
					+ "' and (start_time<='" + dto.getStart_time()
					+ "' and end_time>='" + dto.getStart_time()
					+ "') or (start_time<='" + dto.getEnd_time()
					+ "' and end_time>='" + dto.getEnd_time() + "')";
			System.out.println(query);
			PreparedStatement ps = con.prepareStatement(query);
			// ps.setString(1, dto.getUsername());
			// ps.setString(2, dto.getC_date());
			// ps.setString(3, dto.getStart_time());
			// ps.setString(4, dto.getStart_time());
			// ps.setString(5, dto.getEnd_time());
			// ps.setString(6, dto.getEnd_time());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				newDto = new TimeLogDTO();
				newDto.setUsername(rs.getString("username"));
			}
			rs.close();
			ps.close();

			if (newDto == null) {
				query = "SELECT * FROM tbl_tracker_timelog where username='"
						+ dto.getUsername() + "' and c_date='"
						+ dto.getC_date() + "' and (start_time<='"
						+ dto.getStart_time() + "' and end_time>='"
						+ dto.getStart_time() + "') or (start_time<='"
						+ dto.getEnd_time() + "' and end_time>='"
						+ dto.getEnd_time() + "')";
				System.out.println(query);
				ps = con.prepareStatement(query);
				// ps.setString(1, dto.getUsername());
				// ps.setString(2, dto.getC_date());
				// ps.setString(3, dto.getStart_time());
				// ps.setString(4, dto.getStart_time());
				// ps.setString(5, dto.getEnd_time());
				// ps.setString(6, dto.getEnd_time());
				rs = ps.executeQuery();
				if (rs.next()) {
					newDto = new TimeLogDTO();
					newDto.setUsername(rs.getString("username"));
				}
				rs.close();
				ps.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return newDto;
	}

	private int updateUserTimeLog(TimeLogDTO dto, Connection con) {
		int ret;
		try {
			String query = "update tbl_tracker_timelog set end_time=? where username=? and c_date=? and start_time=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dto.getEnd_time());
			ps.setString(2, dto.getUsername());
			ps.setString(3, dto.getC_date());
			ps.setString(4, dto.getStart_time());
			ret = ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			ret = 0;
		}
		return ret;
	}

	public List<TimeLogDTO> addUserTimeLogs(TimeLogDTO[] list) throws Exception {
		Connection con = null;
		List<TimeLogDTO> ret = new ArrayList<TimeLogDTO>();
		try {
			con = new com.js.db.MyConnection().getConnection();
			for (TimeLogDTO dto : list) {
				TimeLogDTO retdto = new TimeLogDTO();
				retdto.setLog_id(dto.getLog_id());
				retdto.setStatus("no");
				int intRet = 0;
				if (dto.getLog_type().equalsIgnoreCase("manual")) {
					TimeLogDTO checkRet = checkManualTimeLog(dto, con);
					if (checkRet == null) {
						intRet = addManualUserTimeLog(dto, con);
					} else {
						intRet = 2;
					}
				} else if (dto.getLog_type().equalsIgnoreCase("auto")) {
					TimeLogDTO checkRet = checkTimeLog(dto, con);
					if (checkRet == null) {
						intRet = addUserTimeLog(dto, con);
					} else {
						intRet = updateUserTimeLog(dto, con);
					}
				}
				if (intRet == 1) {
					retdto.setStatus("yes");
				} else if (intRet == 2) {
					retdto.setStatus("already");
				} else {
					retdto.setStatus("no");
				}
				ret.add(retdto);
			}
		} finally {
			con.close();
		}
		return ret;
	}

	private int addUserTimeLog(TimeLogDTO dto, Connection con) {
		int ret;
		try {
			String query = "insert into tbl_tracker_timelog(username,c_date,start_time,end_time) values (?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);

			ps.setString(1, dto.getUsername());
			ps.setString(2, dto.getC_date());
			ps.setString(3, dto.getStart_time());
			ps.setString(4, dto.getEnd_time());
			ret = ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			ret = 0;
		}
		return ret;
	}

	private int addManualUserTimeLog(TimeLogDTO dto, Connection con) {
		int ret;
		try {
			String query = "insert into tbl_tracker_manual_timelog(username,c_date,start_time,end_time,m_entry_reson,m_entry_status) values (?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dto.getUsername());
			ps.setString(2, dto.getC_date());
			ps.setString(3, dto.getStart_time());
			ps.setString(4, dto.getEnd_time());
			ps.setString(5, dto.getM_entry_reason());
			ps.setString(6, dto.getM_entry_status());
			System.out.println("date : "+dto.getC_date()+"\ns time : "+dto.getStart_time()+"\ne time : "+dto.getEnd_time());
			ret = ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			ret = 0;
		}
		return ret;
	}

	public int addManualUserTimeLog(TimeLogDTO dto) throws Exception {
		int ret;
		Connection con = null;
		try {
			con = new MyConnection().getConnection();
			String query = "insert into tbl_tracker_manual_timelog(username,c_date,start_time,end_time,m_entry_reson,m_entry_status) values (?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, dto.getUsername());
			ps.setString(2, dto.getC_date());
			ps.setString(3, dto.getStart_time());
			ps.setString(4, dto.getEnd_time());
			ps.setString(5, dto.getM_entry_reason());
			ps.setString(6, dto.getM_entry_status());
			ret = ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
			ret = -1;
		} finally {
			if (con != null) {
				con.close();
			}
		}
		return ret;
	}

	public List<SearchResultDTO> searchUserTimeLog(SearchDTO dto)
			throws Exception {
		List<SearchResultDTO> list = new ArrayList<SearchResultDTO>();

		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			String query = "select * from tbl_tracker_timelog where start_time!=0";
			if (dto.getLog_type() != null) {
				if (dto.getLog_type().equalsIgnoreCase("manual")) {
					query = "select * from tbl_tracker_manual_timelog where m_entry_status='fresh' and start_time!=0";
				}
			}
			if (dto.getUsername() != null
					&& (!dto.getUsername().equalsIgnoreCase("all"))) {
				query = query + " and username='" + dto.getUsername() + "' ";

			} else {
				query = query
						+ " and username in (select employee_id from tbl_tracker_supervisor where supervisor_id='"
						+ dto.getSupId() + "') ";
			}
			if (dto.getLogType().equalsIgnoreCase("today")) {
				Date date = new Date();
				String dateString = TrackerDate.getInstance()
						.getDate_YYYY_MM_DD(date);
				query = query + " and c_date='" + dateString + "' ";
			}
			if (dto.getLogType().equalsIgnoreCase("Week")) {
				Date date = new Date();
				String fromDate = TrackerDate.getInstance().getFirstDayOfWeek(
						date);
				String toDate = TrackerDate.getInstance().getDate_YYYY_MM_DD(
						date);
				query = query + " and c_date between '" + fromDate + "' and '"
						+ toDate + "' ";
			}
			if (dto.getLogType().equalsIgnoreCase("Month")) {
				Date date = new Date();
				String toDate = TrackerDate.getInstance().getDate_YYYY_MM_DD(
						date);
				date.setDate(1);
				String fromDate = TrackerDate.getInstance().getDate_YYYY_MM_DD(
						date);
				query = query + " and c_date between '" + fromDate + "' and '"
						+ toDate + "' ";
			}
			if (dto.getLogType().equalsIgnoreCase("date")) {
				String toDate = TrackerDate.getInstance()
						.changeDateFormate_df_df2(dto.getToDate());
				String fromDate = TrackerDate.getInstance()
						.changeDateFormate_df_df2(dto.getFromDate());
				query = query + " and c_date between '" + fromDate + "' and '"
						+ toDate + "' ";
			}

			query = query
					+ " order by username DESC, c_date DESC,start_time ASC";

			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			String p_user = "";
			long maintime = Long.parseLong("0");
			List<UserDateWiseDTO> dateWiseDTOs = new ArrayList<UserDateWiseDTO>();
			String p_date = "";
			long datetime = Long.parseLong("0");
			List<TimeLogDTO> timeLogDTOs = new ArrayList<TimeLogDTO>();
			String p_sTime = "";
			String p_start_time = "";
			String p_end_time = "";

			TimeLogDTO p_TimeLogDTO = null;
			while (rs.next()) {
				String c_user = rs.getString("username");
				String c_date = rs.getString("c_date");
				String c_start_time = rs.getString("start_time");
				String c_end_time = rs.getString("end_time");

				if (!p_user.equalsIgnoreCase(c_user)
						|| !p_date.equalsIgnoreCase(c_date)
						|| !p_start_time.equalsIgnoreCase(c_start_time)) {
					timeLogDTOs.add(p_TimeLogDTO);
					TimeLogDTO logDTO = new TimeLogDTO();
					logDTO.setStart_time(c_start_time);
					logDTO.setEnd_time(c_end_time);
					logDTO.setUsername(c_user);
					logDTO.setC_date(c_date);
					logDTO.setM_entry_status(rs.getString("m_entry_status"));
					p_TimeLogDTO = logDTO;
				}

				if (!p_user.equalsIgnoreCase(c_user)
						|| !p_date.equalsIgnoreCase(c_date)) {
					UserDateWiseDTO userDateWiseDTO = new UserDateWiseDTO();
					userDateWiseDTO.setDate(p_date);
					userDateWiseDTO.setEtime("" + p_end_time);
					userDateWiseDTO.setStime("" + p_sTime);
					userDateWiseDTO.setTotalhours("" + datetime);
					userDateWiseDTO.setList(timeLogDTOs);
					dateWiseDTOs.add(userDateWiseDTO);

					p_date = c_date;
					datetime = Long.parseLong("0");
					p_sTime = c_start_time;
					timeLogDTOs = new ArrayList<TimeLogDTO>();
				}

				if (!p_user.equalsIgnoreCase(c_user)) {
					SearchResultDTO searchResultDTO = new SearchResultDTO();
					searchResultDTO.setUsername(p_user);
					System.out.println(maintime);

					searchResultDTO.setTotalhours("" + maintime);
					searchResultDTO.setList(dateWiseDTOs);
					list.add(searchResultDTO);

					p_user = c_user;
					maintime = Long.parseLong("0");
					dateWiseDTOs = new ArrayList<UserDateWiseDTO>();
				}

				long start_time = rs.getLong("start_time");
				long end_time = rs.getLong("end_time");
				long temp = end_time - start_time;
				maintime = maintime + temp;
				datetime = datetime + temp;
				p_start_time = c_start_time;
				p_end_time = c_end_time;
			}

			timeLogDTOs.add(p_TimeLogDTO);

			UserDateWiseDTO userDateWiseDTO = new UserDateWiseDTO();
			userDateWiseDTO.setDate(p_date);
			userDateWiseDTO.setEtime("" + p_end_time);
			userDateWiseDTO.setStime("" + p_sTime);
			userDateWiseDTO.setTotalhours("" + datetime);
			userDateWiseDTO.setList(timeLogDTOs);
			dateWiseDTOs.add(userDateWiseDTO);

			SearchResultDTO searchResultDTO = new SearchResultDTO();
			searchResultDTO.setUsername(p_user);
			searchResultDTO.setTotalhours("" + maintime);
			searchResultDTO.setList(dateWiseDTOs);
			list.add(searchResultDTO);

			if (!list.isEmpty() || list.size() > 1) {
				list.remove(0);
			}

			rs.close();
			ps.close();

		} finally {
			con.close();
		}
		return list;
	}

	public List<TimeLogDTO> userManualTimeLog(String supId) throws Exception {
		List<TimeLogDTO> list = new ArrayList<TimeLogDTO>();
		Connection con = null;
		try {
			con = new com.js.db.MyConnection().getConnection();
			String query = "select * from tbl_tracker_manual_timelog where m_entry_status=? and username in (select employee_id from tbl_tracker_supervisor where supervisor_id=?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "fresh");
			ps.setString(2, supId);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				TimeLogDTO tlogin = new TimeLogDTO();
				tlogin.setC_date(rs.getString("c_date"));
				tlogin.setEnd_time(rs.getString("end_time"));
				tlogin.setStart_time(rs.getString("start_time"));
				tlogin.setUsername(rs.getString("username"));
				tlogin.setM_entry_reason(rs.getString("m_entry_reson"));
				tlogin.setM_entry_status(rs.getString("m_entry_status"));
				tlogin.setLog_type("manual");
				list.add(tlogin);
			}
			rs.close();
			ps.close();
		} catch (Exception e) {

		} finally {
			if (con != null) {
				con.close();
			}
		}
		return list;
	}

}
