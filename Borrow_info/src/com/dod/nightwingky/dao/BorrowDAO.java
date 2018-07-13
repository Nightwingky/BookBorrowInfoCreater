package com.dod.nightwingky.dao;

import com.dod.nightwingky.vo.BorrowInfoVO;
import com.dod.nightwingky.base.DBUtil;
import com.dod.nightwingky.vo.ReturnInfoVO;
import com.dod.nightwingky.vo.StuffInfoVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BorrowDAO {

    private static Connection connection;

    static {
        connection = DBUtil.getConnection();
    }

    public static void addBorrowInfo(BorrowInfoVO borrowInfoVO) throws SQLException {
        String sql = "insert into table_borrow_info(stuff_id, book_id, borrow_date, expect_return, " +
                "status_id, isComplete) values (?, ?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, borrowInfoVO.getStuff_id());
        preparedStatement.setInt(2, borrowInfoVO.getBook_id());
        preparedStatement.setTimestamp(3, borrowInfoVO.getBorrow_date());
        preparedStatement.setTimestamp(4, borrowInfoVO.getExpect_return());
        preparedStatement.setInt(5, 1);
        preparedStatement.setInt(6, 0);

        preparedStatement.execute();
    }

    public static void addReturnInfo(ReturnInfoVO returnInfoVO) throws SQLException {
        String sql = "insert into table_return_info(borrow_id, actual_return, status_id) " +
                "values(?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, returnInfoVO.getBorrow_id());
        preparedStatement.setTimestamp(2, returnInfoVO.getActual_return());
        preparedStatement.setInt(3, returnInfoVO.getStatus_id());

        preparedStatement.execute();
    }

    public static List<StuffInfoVO> queryStuffInfo() throws SQLException {
        List<StuffInfoVO> stuffList = new ArrayList<StuffInfoVO>();
        StuffInfoVO stuffInfoVO = null;

        String sql = "select * from table_stuff_info";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery(sql);

        while (resultSet.next()) {
            stuffInfoVO = new StuffInfoVO(
                    resultSet.getInt("stuff_id"),
                    resultSet.getString("stuff_name"),
                    resultSet.getString("gender"),
                    resultSet.getInt("department_id"),
                    resultSet.getString("mobile")
            );
            stuffList.add(stuffInfoVO);
        }

        return stuffList;
    }
}
