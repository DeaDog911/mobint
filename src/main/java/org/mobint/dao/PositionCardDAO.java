package org.mobint.dao;

import org.mobint.utils.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PositionCardDAO {
    public String getNameByGroupId(String groupId) {
        Connection connection = DbUtil.getConnection();
        String query = """
                WITH RECURSIVE r AS (
                    select
                        pc.name,
                        g.groupId,
                        g.parentId,
                        1 as level
                    from "group" g
                             left outer join positionCard pC on g.groupId = pC.groupId
                    where g.groupId = ?
                                
                    union
                                
                    select
                        pc.name,
                        g.groupId,
                        g.parentid,
                        level + 1 as level
                    from positionCard pc
                        join "group" g on g.groupId = pc.groupId
                        join r on g.groupId = r.parentId
                    where pc is not null
                )
                                
                SELECT name
                FROM r
                where name is not null
                order by level
                limit 1;
                """;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, groupId);
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getResultSet();
            resultSet.next();
            return resultSet.getString("name");
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
