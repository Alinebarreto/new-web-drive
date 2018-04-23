package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

@RunWith(DataDrivenTestRunner.class)

@DataLoader(filePaths = "C:\\Users\\Aline Barreto\\IdeaProjects\\webdriver-java\\src\\test\\resources\\PesquisarPassagensTest.csv")

public class PesquisarPassagensTest {

    private WebDriver navegador = null;

    @Before
    public void setUp() {
        //Abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aline Barreto\\Drivers\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //Navegando até a página MarsAirs
        navegador.get("http://alinebarreto.marsair.tw/");
    }

    @Test
    public void testPassagemCupomValidoVazio(@Param(name="code")String code, @Param(name="mensagem")String mensagem) {
        //Clicar no campo ID departing e selecionar value Select...
        WebElement departing = navegador.findElement(By.id("departing"));
        new Select(departing).selectByVisibleText("Select...");

        //Clicar no campo ID returning e selecionar o value "select..." ou valor visível
        WebElement returning = navegador.findElement(By.id("returning"));
        new Select(returning).selectByVisibleText("Select...");

        //Clicar no ID promotional_code e preencher com o code válido, inválido e vazio
        WebElement codeValido = navegador.findElement(By.id("promotional_code"));
        codeValido.sendKeys(code);

        //Clicar no botão "Search" através do xpath
        navegador.findElement(By.xpath("//*[@id=\"content\"]/form/dl[4]/dd")).click();

        //validar a mensagem
        WebElement mensagemTela = navegador.findElement(By.xpath("//*[@id=\"content\"]/p[1]"));
        String mensagem1 = mensagemTela.getText();
        String mensagemReplace = mensagem.replaceAll(";", ",");
        Assert.assertEquals(mensagemReplace, mensagem1);

        //Printar o Resultado
    }

    @Test
    public void testPassagemCupomValidoVazioJuly(@Param(name="code")String code, @Param(name="mensagem")String mensagem) {
        //Clicar no campo ID departing e selecionar value Select...
        WebElement departing = navegador.findElement(By.id("departing"));
        new Select(departing).selectByVisibleText("Select...");

        //Clicar no campo ID returning e selecionar o value "select..." ou valor visível
        WebElement returning = navegador.findElement(By.id("returning"));
        new Select(returning).selectByVisibleText("July (two years from now)");

        //Clicar no ID promotional_code e preencher com o code válido, inválido e vazio
        WebElement codeValido = navegador.findElement(By.id("promotional_code"));
        codeValido.sendKeys(code);

        //Clicar no botão "Search" através do xpath
        navegador.findElement(By.xpath("//*[@id=\"content\"]/form/dl[4]/dd")).click();

        //validar a mensagem
        WebElement mensagemTela = navegador.findElement(By.xpath("//*[@id=\"content\"]/p[1]"));
        String mensagem1 = mensagemTela.getText();
        String mensagemReplace = mensagem.replaceAll(";", ",");
        Assert.assertEquals(mensagemReplace, mensagem1);

        //Printar o Resultado
    }

    @Test
    public void testPassagemCupomValidoVazioDecember(@Param(name="code")String code, @Param(name="mensagem")String mensagem) {
        //Clicar no campo ID departing e selecionar value Select...
        WebElement departing = navegador.findElement(By.id("departing"));
        new Select(departing).selectByVisibleText("Select...");

        //Clicar no campo ID returning e selecionar o value "select..." ou valor visível
        WebElement returning = navegador.findElement(By.id("returning"));
        new Select(returning).selectByVisibleText("December (two years from now)");

        //Clicar no ID promotional_code e preencher com o code válido, inválido e vazio
        WebElement codeValido = navegador.findElement(By.id("promotional_code"));
        codeValido.sendKeys(code);

        //Clicar no botão "Search" através do xpath
        navegador.findElement(By.xpath("//*[@id=\"content\"]/form/dl[4]/dd")).click();

        //validar a mensagem
        WebElement mensagemTela = navegador.findElement(By.xpath("//*[@id=\"content\"]/p[1]"));
        String mensagem1 = mensagemTela.getText();
        String mensagemReplace = mensagem.replaceAll(";", ",");
        Assert.assertEquals(mensagemReplace, mensagem1);

        //Printar o Resultado
    }

    @Test
    public void testPassagemCupomValidoJulyVazio(@Param(name="code")String code, @Param(name="mensagem")String mensagem) {
        //Clicar no campo ID departing e selecionar value Select...
        WebElement departing = navegador.findElement(By.id("departing"));
        new Select(departing).selectByVisibleText("July");

        //Clicar no campo ID returning e selecionar o value "select..." ou valor visível
        WebElement returning = navegador.findElement(By.id("returning"));
        new Select(returning).selectByVisibleText("Select...");

        //Clicar no ID promotional_code e preencher com o code válido, inválido e vazio
        WebElement codeValido = navegador.findElement(By.id("promotional_code"));
        codeValido.sendKeys(code);

        //Clicar no botão "Search" através do xpath
        navegador.findElement(By.xpath("//*[@id=\"content\"]/form/dl[4]/dd")).click();

        //validar a mensagem
        WebElement mensagemTela = navegador.findElement(By.xpath("//*[@id=\"content\"]/p[1]"));
        String mensagem1 = mensagemTela.getText();
        String mensagemReplace = mensagem.replaceAll(";", ",");
        Assert.assertEquals(mensagemReplace, mensagem1);

        //Printar o Resultado
    }

    @Test
    public void testPassagemCupomValidoJulyDecemberTwoYears(@Param(name="code")String code, @Param(name="mensagem")String mensagem) {

        //Clicar no campo ID departing e selecionar value Select...
        WebElement departing = navegador.findElement(By.id("departing"));
        new Select(departing).selectByVisibleText("July");

        //Clicar no campo ID returning e selecionar o value "select..." ou valor visível
        WebElement returning = navegador.findElement(By.id("returning"));
        new Select(returning).selectByVisibleText("December (two years from now)");

        //Clicar no ID promotional_code e preencher com o code válido, inválido e vazio
        WebElement codeValido = navegador.findElement(By.id("promotional_code"));
        codeValido.sendKeys(code);

        //Clicar no botão "Search" através do xpath
        navegador.findElement(By.xpath("//*[@id=\"content\"]/form/dl[4]/dd")).click();

        //validar a mensagem2: Call now on 0800 MARSAIR to book!
        WebElement mensagemTela = navegador.findElement(By.xpath("//div[@id='content']/p[2]"));
        String mensagem2 = mensagemTela.getText();
        String mensagemReplace = mensagem.replaceAll(";", ",");
        Assert.assertEquals(mensagemReplace, mensagem2);


        //Printar o Resultado

    }

    @Test
    public void testPassagemCupomValidoDecemberVazio(@Param(name="code")String code, @Param(name="mensagem")String mensagem) {
        //Clicar no campo ID departing e selecionar value Select...
        WebElement departing = navegador.findElement(By.id("departing"));
        new Select(departing).selectByVisibleText("December");

        //Clicar no campo ID returning e selecionar o value "select..." ou valor visível
        WebElement returning = navegador.findElement(By.id("returning"));
        new Select(returning).selectByVisibleText("Select...");

        //Clicar no ID promotional_code e preencher com o code válido, inválido e vazio
        WebElement codeValido = navegador.findElement(By.id("promotional_code"));
        codeValido.sendKeys(code);

        //Clicar no botão "Search" através do xpath
        navegador.findElement(By.xpath("//*[@id=\"content\"]/form/dl[4]/dd")).click();

        //validar a mensagem
        WebElement mensagemTela = navegador.findElement(By.xpath("//*[@id=\"content\"]/p[1]"));
        String mensagem1 = mensagemTela.getText();
        String mensagemReplace = mensagem.replaceAll(";", ",");
        Assert.assertEquals(mensagemReplace, mensagem1);

        //Printar o Resultado
    }

        @Test
        public void testPassagemCupomValidoDecemberJulyTwoYearsFromNow(@Param(name="code")String code, @Param(name="mensagem")String mensagem) {
            //Clicar no campo ID departing e selecionar value Select...
            WebElement departing = navegador.findElement(By.id("departing"));
            new Select(departing).selectByVisibleText("December");

            //Clicar no campo ID returning e selecionar o value "select..." ou valor visível
            WebElement returning = navegador.findElement(By.id("returning"));
            new Select(returning).selectByVisibleText("July (two years from now)");

            //Clicar no ID promotional_code e preencher com o code válido, inválido e vazio
            WebElement codeValido = navegador.findElement(By.id("promotional_code"));
            codeValido.sendKeys(code);

            //Clicar no botão "Search" através do xpath
            navegador.findElement(By.xpath("//*[@id=\"content\"]/form/dl[4]/dd")).click();

            //validar a mensagem
            WebElement mensagemTela = navegador.findElement(By.xpath("//*[@id=\"content\"]/p[1]"));
            String mensagem1 = mensagemTela.getText();
            String mensagemReplace = mensagem.replaceAll(";", ",");
            Assert.assertEquals(mensagemReplace, mensagem1);

            //Printar o Resultado

        }

    @Test
    public void testPassagemCupomValidoDecemberNextYearVazio(@Param(name="code")String code, @Param(name="mensagem")String mensagem) {
        //Clicar no campo ID departing e selecionar value Select...
        WebElement departing = navegador.findElement(By.id("departing"));
        new Select(departing).selectByVisibleText("December (next year)");

        //Clicar no campo ID returning e selecionar o value "select..." ou valor visível
        WebElement returning = navegador.findElement(By.id("returning"));
        new Select(returning).selectByVisibleText("Select...");

        //Clicar no ID promotional_code e preencher com o code válido, inválido e vazio
        WebElement codeValido = navegador.findElement(By.id("promotional_code"));
        codeValido.sendKeys(code);

        //Clicar no botão "Search" através do xpath
        navegador.findElement(By.xpath("//*[@id=\"content\"]/form/dl[4]/dd")).click();

        //validar a mensagem
        WebElement mensagemTela = navegador.findElement(By.xpath("//*[@id=\"content\"]/p[1]"));
        String mensagem1 = mensagemTela.getText();
        String mensagemReplace = mensagem.replaceAll(";", ",");
        Assert.assertEquals(mensagemReplace, mensagem1);

        //Printar o Resultado

    }


    @Test
    public void testPassagemCupomValidoJulyNextYearJulyTwoYears(@Param(name="code")String code, @Param(name="mensagem")String mensagem) {
        //Clicar no campo ID departing e selecionar value Select...
        WebElement departing = navegador.findElement(By.id("departing"));
        new Select(departing).selectByVisibleText("July (next year)");

        //Clicar no campo ID returning e selecionar o value "select..." ou valor visível
        WebElement returning = navegador.findElement(By.id("returning"));
        new Select(returning).selectByVisibleText("July (two years from now)");

        //Clicar no ID promotional_code e preencher com o code válido, inválido e vazio
        WebElement codeValido = navegador.findElement(By.id("promotional_code"));
        codeValido.sendKeys(code);

        //Clicar no botão "Search" através do xpath
        navegador.findElement(By.xpath("//*[@id=\"content\"]/form/dl[4]/dd")).click();

        //validar a mensagem
        WebElement mensagemTela = navegador.findElement(By.xpath("//*[@id=\"content\"]/p[1]"));
        String mensagem1 = mensagemTela.getText();
        String mensagemReplace = mensagem.replaceAll(";", ",");
        Assert.assertEquals(mensagemReplace, mensagem1);

        //Printar o Resultado

    }

    @Test
    public void testPassagemCupomValidoDecemberNextYearDecemberTwoYears(@Param(name="code")String code, @Param(name="mensagem")String mensagem) {
        //Clicar no campo ID departing e selecionar value Select...
        WebElement departing = navegador.findElement(By.id("departing"));
        new Select(departing).selectByVisibleText("December (next year)");

        //Clicar no campo ID returning e selecionar o value "select..." ou valor visível
        WebElement returning = navegador.findElement(By.id("returning"));
        new Select(returning).selectByVisibleText("December (two years from now)");

        //Clicar no ID promotional_code e preencher com o code válido, inválido e vazio
        WebElement codeValido = navegador.findElement(By.id("promotional_code"));
        codeValido.sendKeys(code);

        //Clicar no botão "Search" através do xpath
        navegador.findElement(By.xpath("//*[@id=\"content\"]/form/dl[4]/dd")).click();

        //validar a mensagem
        WebElement mensagemTela = navegador.findElement(By.xpath("//*[@id=\"content\"]/p[1]"));
        String mensagem1 = mensagemTela.getText();
        String mensagemReplace = mensagem.replaceAll(";", ",");
        Assert.assertEquals(mensagemReplace, mensagem1);

        //Printar o Resultado
    }

    @Test
    public void testPassagemCupomValidoJulyNextYearDecemberTwoYears(@Param(name="code")String code, @Param(name="mensagem")String mensagem) {
        //Clicar no campo ID departing e selecionar value Select...
        WebElement departing = navegador.findElement(By.id("departing"));
        new Select(departing).selectByVisibleText("July (next year)");

        //Clicar no campo ID returning e selecionar o value "select..." ou valor visível
        WebElement returning = navegador.findElement(By.id("returning"));
        new Select(returning).selectByVisibleText("December (two years from now)");

        //Clicar no ID promotional_code e preencher com o code válido, inválido e vazio
        WebElement codeValido = navegador.findElement(By.id("promotional_code"));
        codeValido.sendKeys(code);

        //Clicar no botão "Search" através do xpath
        navegador.findElement(By.xpath("//*[@id=\"content\"]/form/dl[4]/dd")).click();

        //validar a mensagem
        WebElement mensagemTela = navegador.findElement(By.xpath("//*[@id=\"content\"]/p[1]"));
        String mensagem1 = mensagemTela.getText();
        String mensagemReplace = mensagem.replaceAll(";", ",");
        Assert.assertEquals(mensagemReplace, mensagem1);

        //Printar o Resultado
    }

    @Test
    public void testPassagemCupomValidoDecemberNextYearJulyTwoYears(@Param(name="code")String code, @Param(name="mensagem")String mensagem) {
        //Clicar no campo ID departing e selecionar value Select...
        WebElement departing = navegador.findElement(By.id("departing"));
        new Select(departing).selectByVisibleText("December (next year)");

        //Clicar no campo ID returning e selecionar o value "select..." ou valor visível
        WebElement returning = navegador.findElement(By.id("returning"));
        new Select(returning).selectByVisibleText("July (two years from now)");

        //Clicar no ID promotional_code e preencher com o code válido, inválido e vazio
        WebElement codeValido = navegador.findElement(By.id("promotional_code"));
        codeValido.sendKeys(code);

        //Clicar no botão "Search" através do xpath
        navegador.findElement(By.xpath("//*[@id=\"content\"]/form/dl[4]/dd")).click();

        //validar a mensagem3: Unfortunately, this schedule is not possible. Please try again.
        WebElement mensagemTela = navegador.findElement(By.xpath("//*[@id=\"content\"]/p[1]"));
        String mensagem3 = mensagemTela.getText();
        String mensagemReplace = mensagem.replaceAll(";", ",");
        Assert.assertEquals(mensagemReplace, mensagem3);

        //Printar o Resultado
    }
    @After
    public void tearDown(){

        //Clicar no Botão 'back' através do xpath
        navegador.findElement(By.xpath("//a[text()=' Back']")).click();
        //Limpar o campo Promotional code através do seu ID
        navegador.findElement(By.id("promotional_code")).clear();
        //Fechar o navegador
        navegador.quit();
}
}
