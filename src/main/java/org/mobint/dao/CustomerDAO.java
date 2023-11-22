package org.mobint.dao;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.mobint.utils.DbUtil;

import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CustomerDAO {
    public List<Map<String, String>> getCustomers(int offset) {
        Connection connection = DbUtil.getConnection();
        String query = """ 
                select *
                from customer c
                	left join table_1 t1 on t1.customerId = c.customerId
                	left join table_2 t2 on t2.customerId = c.customerId
                	left join table_3 t3 on t3.customerId = c.customerId
                	left join table_4 t4 on t4.customerId = c.customerId
                	left join table_5 t5 on t5.customerId = c.customerId
                	left join table_6 t6 on t6.customerId = c.customerId
                	left join table_7 t7 on t7.customerId = c.customerId
                	left join table_8 t8 on t8.customerId = c.customerId
                	left join table_9 t9 on t9.customerId = c.customerId
                	left join table_10 t10 on t10.customerId = c.customerId
                	left join table_11 t11 on t11.customerId = c.customerId
                	left join table_12 t12 on t12.customerId = c.customerId
                	left join table_13 t13 on t13.customerId = c.customerId
                	left join table_14 t14 on t14.customerId = c.customerId
                	left join table_15 t15 on t15.customerId = c.customerId
                	left join table_16 t16 on t16.customerId = c.customerId
                	left join table_17 t17 on t17.customerId = c.customerId
                	left join table_18 t18 on t18.customerId = c.customerId
                	left join table_19 t19 on t19.customerId = c.customerId
                	left join table_20 t20 on t20.customerId = c.customerId
                	left join table_21 t21 on t21.customerId = c.customerId
                	left join table_22 t22 on t22.customerId = c.customerId
                	left join table_23 t23 on t23.customerId = c.customerId
                	left join table_24 t24 on t24.customerId = c.customerId
                	left join table_25 t25 on t25.customerId = c.customerId
                	left join table_26 t26 on t26.customerId = c.customerId
                	left join table_27 t27 on t27.customerId = c.customerId
                	left join table_28 t28 on t28.customerId = c.customerId
                	left join table_29 t29 on t29.customerId = c.customerId
                	left join table_30 t30 on t30.customerId = c.customerId                                    
                	left join table_many tm on c.customerId = tm.customerId
                order by c.customerId
                offset ? limit 5000
                """;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, offset);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            List<Map<String, String>> result  = new LinkedList<>();
            while (resultSet.next()) {
                Map<String, String> map = new HashMap<>();
                for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                    String columnLabel = resultSet.getMetaData().getTableName(i) + "." + resultSet.getMetaData().getColumnLabel(i);
                    String value = resultSet.getString(i);
                    map.put(columnLabel, value);
                }
                result.add(map);
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
