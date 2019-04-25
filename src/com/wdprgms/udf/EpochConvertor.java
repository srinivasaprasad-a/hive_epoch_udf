package com.wdprgms.udf;

import java.time.*;
import java.time.format.DateTimeFormatter;

import org.apache.hadoop.hive.ql.exec.Description;
import org.apache.hadoop.hive.ql.exec.UDF;

@Description(name = "EpochConvertor", 
value="_FUNC_(string) - Convert UnixTimestamp to Human Readable Format",
extended = "Example:\n" 
			+ " SELECT _FUNC_(epoch, timezone) FROM src;\n"
			+ " epoch as BIGINT, timezone as STRING")

public final class EpochConvertor extends UDF{
	
	public String evaluate(final long epoch_val, final String tz_val) {
		ZonedDateTime dateTime = Instant.ofEpochMilli(epoch_val/1000).atZone(ZoneId.of(tz_val));
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
		//System.out.println(formatter.format(dateTime));
		return formatter.format(dateTime);		
	}	
}