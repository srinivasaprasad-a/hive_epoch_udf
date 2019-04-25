package com.wdprgms.udf;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestEpochConvertor {

	@Test
	public void testepochconvertor() {
		assertEquals((new EpochConvertor()).evaluate(1507603869624666L, "Etc/UTC"), "2017-10-10");
		assertEquals((new EpochConvertor()).evaluate(1507603869624666L, "UTC"), "2017-10-10");
		assertEquals((new EpochConvertor()).evaluate(1507603869624666L, "GMT"), "2017-10-10");
		assertEquals((new EpochConvertor()).evaluate(1507603869624666L, "EST5EDT"), "2017-10-09");
		assertEquals((new EpochConvertor()).evaluate(1507603869624666L, "SystemV/EST5"), "2017-10-09");
	}
}
