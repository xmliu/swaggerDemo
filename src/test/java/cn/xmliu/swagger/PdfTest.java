package cn.xmliu.swagger;


import io.github.swagger2markup.GroupBy;
import io.github.swagger2markup.Language;
import io.github.swagger2markup.Swagger2MarkupConfig;
import io.github.swagger2markup.Swagger2MarkupConverter;
import io.github.swagger2markup.builder.Swagger2MarkupConfigBuilder;
import io.github.swagger2markup.markup.builder.MarkupLanguage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.nio.file.Paths;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PdfTest {

    @Test
    public void generateAsciiDocs() throws Exception {

        // 输出Ascii格式
        Swagger2MarkupConfig config = new Swagger2MarkupConfigBuilder().withMarkupLanguage(MarkupLanguage.ASCIIDOC)
                .withOutputLanguage(Language.ZH).withPathsGroupedBy(GroupBy.TAGS).withGeneratedExamples()
                .withoutInlineSchema().build();

        Swagger2MarkupConverter.from(new URL("http://localhost:8080/v2/api-docs?group=xmliu")).withConfig(config)
                .build().toFolder(Paths.get("src/docs/asciidoc/generated"));
    }

}
