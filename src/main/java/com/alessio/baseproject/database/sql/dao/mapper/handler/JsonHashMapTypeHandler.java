package com.alessio.baseproject.database.sql.dao.mapper.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.postgresql.util.PGobject;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

@MappedJdbcTypes(JdbcType.OTHER)
@MappedTypes(HashMap.class)
public class JsonHashMapTypeHandler extends BaseTypeHandler<HashMap> {

    private static final String JSONB_TYPE = "jsonb";

    @Override
    public void setNonNullParameter(PreparedStatement arg0, int arg1, HashMap arg2, JdbcType arg3) throws SQLException {
        try {
            String value = null;
            if (arg2 != null) {
                value = new ObjectMapper().writeValueAsString(arg2);
            }
            PGobject jsonObject = new PGobject();
            jsonObject.setType(JSONB_TYPE);
            jsonObject.setValue(value);
            arg0.setObject(arg1, jsonObject);
        } catch (IOException e) {
            throw new SQLException(e);
        }
    }

    @Override
    public HashMap getNullableResult(ResultSet res, String columnName) throws SQLException {
        return getNullableResult(res.getString(columnName));
    }

    @Override
    public HashMap getNullableResult(ResultSet res, int arg1) throws SQLException {
        return getNullableResult(res.getString(arg1));
    }

    @Override
    public HashMap getNullableResult(CallableStatement res, int arg1) throws SQLException {
        return getNullableResult(res.getString(arg1));
    }

    private HashMap getNullableResult(String string) throws SQLException {
        try {
            return StringUtils.isBlank(string)
                    ? null
                    : new ObjectMapper().readValue(string, HashMap.class);
        } catch (IOException e) {
            throw new SQLException(e);
        }
    }
}
