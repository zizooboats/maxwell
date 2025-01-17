package com.zendesk.maxwell.schema.columndef;

import com.zendesk.maxwell.producer.MaxwellOutputConfig;

import java.sql.Date;
import java.util.Calendar;

public class YearColumnDef extends ColumnDef {
	public YearColumnDef(String name, String type, short pos, boolean nullable) {
		super(name, type, pos, nullable);
	}

	public static YearColumnDef create(String name, String type, short pos, boolean nullable) {
		YearColumnDef temp = new YearColumnDef(name, type, pos, nullable);
		return (YearColumnDef) INTERNER.intern(temp);
	}

	@Override
	public Object asJSON(Object value, MaxwellOutputConfig outputConfig) {
		if ( value instanceof Date ) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(( java.sql.Date ) value);
			return calendar.get(Calendar.YEAR);
		}
		return value;
	}

	@Override
	public String toSQL(Object value) {
		return ((Integer)value).toString();
	}

}
