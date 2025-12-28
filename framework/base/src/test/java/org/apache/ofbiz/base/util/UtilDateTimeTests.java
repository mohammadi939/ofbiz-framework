/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.ofbiz.base.util;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.Test;

import com.ibm.icu.text.SimpleDateFormat;
import com.ibm.icu.util.PersianCalendar;

public class UtilDateTimeTests {

    @Test
    public void testFormatPersianDateDefaultPattern() {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        Locale locale = new Locale("fa");
        Date date = new Date(1710892800000L);
        PersianCalendar calendar = new PersianCalendar(locale);
        calendar.setTimeZone(com.ibm.icu.util.TimeZone.getTimeZone(timeZone.getID()));
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd", locale);
        formatter.setCalendar(calendar);
        formatter.setTimeZone(calendar.getTimeZone());
        String expected = formatter.format(date);

        assertEquals(expected, UtilDateTime.formatPersianDate(date, null, timeZone, locale));
    }

    @Test
    public void testFormatPersianDateCustomPatternAndNull() {
        TimeZone timeZone = TimeZone.getTimeZone("UTC");
        Locale locale = Locale.US;
        Date date = new Date(1710892800000L);
        String expected = "1403-01-01";

        assertEquals(expected, UtilDateTime.formatPersianDate(date, "yyyy-MM-dd", timeZone, locale));
        assertEquals("", UtilDateTime.formatPersianDate(null, "yyyy-MM-dd", timeZone, locale));
    }
}
