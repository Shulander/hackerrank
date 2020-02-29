package us.vicentini.hackerrank.warmup;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import us.vicentini.hackerrank.BaseSystemStreamOverride;

import java.io.InputStream;

@Slf4j
class AlternatingCharactersTest extends BaseSystemStreamOverride {

    @Test
    public void testCase01() {
        InputStream inputStream = getResourceAsStream("AlternatingCharacters_01_input.txt");
        InputStream expectedStream = getResourceAsStream("AlternatingCharacters_01_output.txt");
        provideInput(inputStream);

        AlternatingCharacters.main(new String[0]);

        assertInputStreams(expectedStream, getOutputAsInputStream());
    }
}
