package com.alessio.baseproject.database.sql.dao.mapper.handler;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.sql.*;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.TimeZone;

@MappedJdbcTypes(JdbcType.TIMESTAMP_WITH_TIMEZONE)
@MappedTypes(DateTime.class)
public class JsonDateTimeWithMillisTypeHandler extends BaseTypeHandler<DateTime> {

    private static final String TIMESTAMP_PATTERN_WITH_MILLISECONDS = "yyyy-MM-dd HH:mm:ss.SSSZZ";
    private static final String TIMESTAMP_PATTERN_WITHOUT_MILLISECONDS = "yyyy-MM-dd HH:mm:ssZZ";
    private static final DateTimeFormatter FORMATTER_WITH_MILLISECONDS = DateTimeFormat.forPattern(TIMESTAMP_PATTERN_WITH_MILLISECONDS);
    private static final DateTimeFormatter FORMATTER_WITHOUT_MILLISECONDS = DateTimeFormat.forPattern(TIMESTAMP_PATTERN_WITHOUT_MILLISECONDS);
    private static final Calendar CALENDAR = Calendar.getInstance(TimeZone.getTimeZone(ZoneOffset.UTC));

    @Override
    public void setNonNullParameter(PreparedStatement arg0, int arg1, DateTime arg2, JdbcType arg3) throws SQLException {
        if (arg2 != null) {
            arg0.setTimestamp(arg1, new Timestamp(arg2.getMillis()), CALENDAR);
        }
    }

    @Override
    public DateTime getNullableResult(ResultSet res, String columnName) throws SQLException {
        return getNullableResult(res.getString(columnName));
    }

    @Override
    public DateTime getNullableResult(ResultSet res, int arg1) throws SQLException {
        return getNullableResult(res.getString(arg1));
    }

    @Override
    public DateTime getNullableResult(CallableStatement res, int arg1) throws SQLException {
        return getNullableResult(res.getString(arg1));
    }

    private DateTime getNullableResult(String string) {
        if (StringUtils.isBlank(string)) {
            return null;
        } else {
            try {
                return DateTime.parse(string, FORMATTER_WITH_MILLISECONDS);
            } catch (Exception e) {
                //workaround: org.postgresql.jdbc.TimestampUtils.toString(Calendar cal, Timestamp x, boolean withTimeZone) removes millisconds from String if they are set to zero
                return DateTime.parse(string, FORMATTER_WITHOUT_MILLISECONDS);
            }
        }
    }
}