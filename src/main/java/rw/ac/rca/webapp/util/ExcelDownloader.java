package rw.ac.rca.webapp.util;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.core.io.InputStreamResource;
import rw.ac.rca.webapp.orm.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
public class ExcelDownloader {

    public static void DownloadManagersExcel(List<Manager> managers, HttpServletResponse response) {
        try (Workbook workbook = new SXSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream();
             ServletOutputStream servletOutputStream = response.getOutputStream()) {

            int k = 1;
            String sheetTitle = "students list";
            Sheet sheet = workbook.createSheet(sheetTitle.replace("/", "&"));
            Row headRow = sheet.createRow(0);
            headRow.createCell(0).setCellValue("Id");
            headRow.createCell(1).setCellValue("FirstName");
            headRow.createCell(2).setCellValue("LastName");
            headRow.createCell(3).setCellValue("phoneNumber");
            headRow.createCell(4).setCellValue("Date of Birth");
            int rowIndex = 1;

            for (Manager manager : managers) {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(k);
                if (manager.getFirstName() == null) {
                    row.createCell(1).setCellValue("");
                } else {
                    row.createCell(1).setCellValue(manager.getFirstName());
                }
                if (manager.getLastName() == null) {
                    row.createCell(2).setCellValue("");
                } else {
                    row.createCell(2).setCellValue(manager.getLastName());
                }
                if (manager.getPhoneNumber() == null) {
                    row.createCell(3).setCellValue("");
                } else {
                    row.createCell(3).setCellValue(manager.getPhoneNumber());
                }
                if (manager.getDateOfBirth() == null) {
                    row.createCell(4).setCellValue("");
                } else {
                    row.createCell(4).setCellValue(manager.getDateOfBirth());
                }
                k++;
            }

            workbook.write(out);

            InputStreamResource file = new InputStreamResource(new ByteArrayInputStream(out.toByteArray()));
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=" + "managers" + ".xlsx");

            servletOutputStream.write(out.toByteArray());
            servletOutputStream.flush();
        } catch (Exception exception) {
            System.out.println("Error, failed to export excel file: " + exception.getMessage());
        }
    }

    public static void downloadCourses(List<Course> courses, HttpServletResponse response){
        try (Workbook workbook = new SXSSFWorkbook()) {
                 ByteArrayOutputStream out = new ByteArrayOutputStream();
                 ServletOutputStream servletOutputStream = response.getOutputStream();

                int k = 1;
                String sheetTitle = "students list";
                Sheet sheet = workbook.createSheet(sheetTitle.replace("/", "&"));
                Row headRow = sheet.createRow(0);
                headRow.createCell(0).setCellValue("Id");
                headRow.createCell(1).setCellValue("Name");
                headRow.createCell(2).setCellValue("Code");
                headRow.createCell(3).setCellValue("Start");
                headRow.createCell(4).setCellValue("End");
                int rowIndex = 1;

                for (Course course : courses) {
                    Row row = sheet.createRow(rowIndex++);
                    row.createCell(0).setCellValue(k);
                    if (course.getName() == null) {
                        row.createCell(1).setCellValue("");
                    } else {
                        row.createCell(1).setCellValue(course.getName());
                    }
                    if (course.getCode() == null) {
                        row.createCell(2).setCellValue("");
                    } else {
                        row.createCell(2).setCellValue(course.getCode());
                    }
                    if (course.getStart() == null) {
                        row.createCell(3).setCellValue("");
                    } else {
                        row.createCell(3).setCellValue(course.getStart());
                    }
                    if (course.getEnd() == null) {
                        row.createCell(4).setCellValue("");
                    } else {
                        row.createCell(4).setCellValue(course.getEnd());
                    }
                    k++;
                }

                workbook.write(out);

                InputStreamResource file = new InputStreamResource(new ByteArrayInputStream(out.toByteArray()));
                response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                response.setHeader("Content-Disposition", "attachment; filename=" + "courses" + ".xlsx");

                servletOutputStream.write(out.toByteArray());
                servletOutputStream.flush();

        }catch (Exception e){
            System.out.println("Error, failed to export the excel file : " + e.getMessage());
        }
    }

    public static void downloadUsersExcel(List<User> users, HttpServletResponse response){
        try (Workbook workbook = new SXSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream();
             ServletOutputStream servletOutputStream = response.getOutputStream()) {

            int k = 1;
            String sheetTitle = "students list";
            Sheet sheet = workbook.createSheet(sheetTitle.replace("/", "&"));
            Row headRow = sheet.createRow(0);
            headRow.createCell(0).setCellValue("Id");
            headRow.createCell(1).setCellValue("FullName");
            headRow.createCell(2).setCellValue("UserName");
            headRow.createCell(3).setCellValue("Email");
            headRow.createCell(4).setCellValue("Role");
            int rowIndex = 1;

            for (User user : users) {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(k);
                if (user.getFullName() == null) {
                    row.createCell(1).setCellValue("");
                } else {
                    row.createCell(1).setCellValue(user.getFullName());
                }
                if (user.getUsername() == null) {
                    row.createCell(2).setCellValue("");
                } else {
                    row.createCell(2).setCellValue(user.getUsername());
                }
                if (user.getEmail() == null) {
                    row.createCell(3).setCellValue("");
                } else {
                    row.createCell(3).setCellValue(user.getEmail());
                }
                if (user.getUserRole() == null) {
                    row.createCell(4).setCellValue("");
                } else {
                    row.createCell(4).setCellValue(user.getUserRole().name());
                }
                k++;
            }

            workbook.write(out);

            InputStreamResource file = new InputStreamResource(new ByteArrayInputStream(out.toByteArray()));
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=" + "users" + ".xlsx");

            servletOutputStream.write(out.toByteArray());
            servletOutputStream.flush();
        } catch (Exception exception) {
            System.out.println("Error, failed to export excel file: " + exception.getMessage());
        }

    }

    public static void downloadStudentsExcel(List<Student> students, HttpServletResponse response){
        try (Workbook workbook = new SXSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream();
             ServletOutputStream servletOutputStream = response.getOutputStream()) {

            int k = 1;
            String sheetTitle = "students list";
            Sheet sheet = workbook.createSheet(sheetTitle.replace("/", "&"));
            Row headRow = sheet.createRow(0);
            headRow.createCell(0).setCellValue("Id");
            headRow.createCell(1).setCellValue("FirstName");
            headRow.createCell(2).setCellValue("lastName");
            headRow.createCell(3).setCellValue("phoneNumber");
            headRow.createCell(4).setCellValue("dateOfBirth");
            headRow.createCell(5).setCellValue("isInternational");
            headRow.createCell(6).setCellValue("isPartTime");
            headRow.createCell(7).setCellValue("isRepeating");
            int rowIndex = 1;

            for (Student user : students) {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(k);
                if (user.getFirstName() == null) {
                    row.createCell(1).setCellValue("");
                } else {
                    row.createCell(1).setCellValue(user.getFirstName());
                }
                if (user.getLastName() == null) {
                    row.createCell(2).setCellValue("");
                } else {
                    row.createCell(2).setCellValue(user.getLastName());
                }
                if (user.getPhoneNumber() == null) {
                    row.createCell(3).setCellValue("");
                } else {
                    row.createCell(3).setCellValue(user.getPhoneNumber());
                }
                if (user.getDateOfBirth() == null) {
                    row.createCell(4).setCellValue("");
                } else {
                    row.createCell(4).setCellValue(user.getDateOfBirth());
                }
                row.createCell(2).setCellValue("False");
                row.createCell(2).setCellValue("False");
                row.createCell(2).setCellValue("True");
                k++;
            }

            workbook.write(out);

            InputStreamResource file = new InputStreamResource(new ByteArrayInputStream(out.toByteArray()));
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=" + "students" + ".xlsx");

            servletOutputStream.write(out.toByteArray());
            servletOutputStream.flush();
        } catch (Exception exception) {
            System.out.println("Error, failed to export excel file: " + exception.getMessage());
        }
    }


    public static void downloadInstructorsExcel(List<Instructor> instructors, HttpServletResponse response){
        try (Workbook workbook = new SXSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream();
             ServletOutputStream servletOutputStream = response.getOutputStream()) {

            int k = 1;
            String sheetTitle = "students list";
            Sheet sheet = workbook.createSheet(sheetTitle.replace("/", "&"));
            Row headRow = sheet.createRow(0);
            headRow.createCell(0).setCellValue("Id");
            headRow.createCell(1).setCellValue("FirstName");
            headRow.createCell(2).setCellValue("lastName");
            headRow.createCell(3).setCellValue("phoneNumber");
            headRow.createCell(4).setCellValue("dateOfBirth");
            headRow.createCell(5).setCellValue("Renumeration time");
            headRow.createCell(6).setCellValue("isPartTime");
            headRow.createCell(7).setCellValue("isRepeating");
            int rowIndex = 1;

            for (Instructor user : instructors) {
                Row row = sheet.createRow(rowIndex++);
                row.createCell(0).setCellValue(k);
                if (user.getFirstName() == null) {
                    row.createCell(1).setCellValue("");
                } else {
                    row.createCell(1).setCellValue(user.getFirstName());
                }
                if (user.getLastName() == null) {
                    row.createCell(2).setCellValue("");
                } else {
                    row.createCell(2).setCellValue(user.getLastName());
                }
                if (user.getPhoneNumber() == null) {
                    row.createCell(3).setCellValue("");
                } else {
                    row.createCell(3).setCellValue(user.getPhoneNumber());
                }
//                if ((user.getSalary() == null)) {
//                    row.createCell(4).setCellValue("");
//                } else {
//                    row.createCell(4).setCellValue(user.getSalary());
//                }
                if ((user.getDateOfBirth() == null)) {
                    row.createCell(4).setCellValue("");
                } else {
                    row.createCell(4).setCellValue(user.getDateOfBirth());
                }
                if ((user.getRemunerationDate() == null)) {
                    row.createCell(5).setCellValue("");
                } else {
                    row.createCell(5).setCellValue(user.getRemunerationDate());
                }
                row.createCell(6).setCellValue("False");
                row.createCell(7).setCellValue("False");
                k++;
            }

            workbook.write(out);

            InputStreamResource file = new InputStreamResource(new ByteArrayInputStream(out.toByteArray()));
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setHeader("Content-Disposition", "attachment; filename=" + "instructors" + ".xlsx");

            servletOutputStream.write(out.toByteArray());
            servletOutputStream.flush();
        } catch (Exception exception) {
            System.out.println("Error, failed to export excel file: " + exception.getMessage());
        }
    }

}
