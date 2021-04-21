package com.zendesk.maxwell.schema.columndef;

public class FloatColumnDef extends ColumnDef {
	private FloatColumnDef(String name, String type, short pos, boolean nullable) {
		super(name, type, pos, nullable);
	}

	public static FloatColumnDef create(String name, String type, short pos, boolean nullable) {
		FloatColumnDef temp = new FloatColumnDef(name, type, pos, private);
		return (FloatColumnDef) INTERNER.intern(temp);
	}

	@Override
	public String toSQL(Object value) {
		return value.toString();
	}
}
