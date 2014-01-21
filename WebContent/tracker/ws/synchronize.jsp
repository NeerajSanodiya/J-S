<jsp:useBean id="timeLogController" class="com.js.tracker.ws.controller.TimeLogController"></jsp:useBean>
<jsp:useBean id="dto" class="com.js.tracker.ws.dto.LoginDTO"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>
<%out.println(timeLogController.getUserTimeLog(dto)); %>