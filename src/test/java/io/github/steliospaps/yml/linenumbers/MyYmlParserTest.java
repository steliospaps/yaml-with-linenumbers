package io.github.steliospaps.yml.linenumbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MyYmlParserTest {

    private MyYmlParser impl;

    @BeforeEach
    void setUp() {
        impl = new MyYmlParser();
    }

    @Test
    void test() {
    String    yml="""
    title: my yml
    child:
        type: A
        val: 3
        child:
            type: B
            children:
                - type: C
                  val: 1
                - type: B
                  children:
                    - type: C
                      val: 2
    """;

        Document res = impl.parseYml(yml);

        assertThat(res.child().linenumber()).isEqualTo(3);

        assertThat(((A)res.child()).child().linenumber()).isEqualTo(6);

        assertThat(((B)((A)res.child()).child()).children().get(0).linenumber()).isEqualTo(8);

        assertThat(((B)((A)res.child()).child()).children().get(1).linenumber()).isEqualTo(10);
        assertThat(((B)((B)((A)res.child()).child()).children().get(1)).children().get(0).linenumber()).isEqualTo(12);

        assertThat(impl.writeYml(res)).isEqualTo("""
            title: my yml
            child:
              type: A
              val: 3
              child:
                type: B
                children:
                - type: C
                  val: 1
                - type: B
                  children:
                  - type: C
                    val: 2
            """);

    }
}