package org.dicio.numbers.lang.fr;

import static org.dicio.numbers.test.TestUtils.DAY;
import static org.dicio.numbers.test.TestUtils.HOUR;
import static org.dicio.numbers.test.TestUtils.MINUTE;
import static org.dicio.numbers.test.TestUtils.YEAR;
import static org.dicio.numbers.test.TestUtils.t;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.dicio.numbers.ParserFormatter;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExtractDurationTest {

    private static ParserFormatter pf;

    @BeforeClass
    public static void setup() {
        pf = new ParserFormatter(new FrenchFormatter(), new FrenchParser());
    }

    @Test
    public void testExtractDuration() {
        assertEquals(t(2 * MINUTE + 30),
                pf.extractDuration("un minuteur de deux minutes et trente secondes").get());
        assertEquals(t(2 * YEAR),
                pf.extractDuration("il y a deux ans").get());
        assertEquals(t(23 * HOUR),
                pf.extractDuration("vingt-trois heures").get());
        assertEquals(t(5 * DAY),
                pf.extractDuration("cinq jours").get());
    }

    @Test
    public void testExtractDurationNull() {
        assertNull(pf.extractDuration("bonjour le monde").get());
    }
}
