package jdbc;  // jdbc 패키지를 정의

import java.sql.*;  // JDBC 관련 클래스들을 임포트
import java.util.UUID;  // UUID 클래스를 임포트
import java.util.Scanner;

public class insertTest {  // 'test'라는 이름의 클래스 정의

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 메인 메서드: 프로그램의 진입점

        // MariaDB JDBC 드라이버 로드
        Class.forName("org.mariadb.jdbc.Driver");
        System.out.println("Drive ok");  // 드라이버가 성공적으로 로드되었음을 출력

        // 데이터베이스에 연결
        Connection conn = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/board",  // JDBC URL: 데이터베이스 주소
                "root",  // 데이터베이스 사용자 이름
                "0000"   // 데이터베이스 비밀번호
        );

        System.out.println("Connection is ok " + conn);  // 연결이 성공했음을 출력
        PreparedStatement pstmt = conn.prepareStatement(
        		"delete from board where seq like ?"
        		);
        
        Scanner scan = new Scanner(System.in);
        System.out.println("seq? ");
        String seq = scan.next();
	    pstmt.setString(1, "%"+ seq + "%"); 
	    pstmt.executeUpdate();
	    System.out.println("delete is ok"); 
	}
}
