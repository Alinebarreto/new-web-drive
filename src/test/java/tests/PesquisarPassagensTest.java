package tests;

import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "PesquisarPassagensTest.csv")
public class PesquisarPassagensTest {
    private WebDriver navegador;

    //@Rule
    //public TestName test = new TestName();

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
    public void testPassagemCupomValidoVazio(@Param(name="code")String code, @Param(name="mensagem")String mensagem){
        //Clicar no campo ID departing e selecionar value Select...
        WebElement departing = navegador.findElement(By.id("departing"));
        new Select(departing).selectByVisibleText("Select...");

        //Clicar no campo ID returning e selecionar o value "select..." ou valor visível
        WebElement returning = navegador.findElement(By.id("returning"));
        new Select(returning).selectByVisibleText("Select...");

        //Clicar no ID promotional_code e preencher com o valor "AA1-AAA- 124"
        WebElement codeValido = navegador.findElement(By.id("promotional_code"));
        codeValido.sendKeys(code);

        //Clicar no botão "Search" através do xpath
        navegador.findElement(By.xpath("//*[@id=\"content\"]/form/dl[4]/dd")).click();

        //validar a mensagem
        WebElement mensagemTela = navegador.findElement(By.xpath("//*[@id=\"content\"]/p[1]"));
        String mensagem1 = mensagemTela.getText();
        Assert.assertEquals(mensagem, mensagem1);

        //Printar o Resultado
    }

    @Test
    public void testPassagemCupomValidoVazioJuly() {
        //Clicar no campo ID departing e selecionar value Select...
        WebElement departing = navegador.findElement(By.id("departing"));
        new Select(departing).selectByVisibleText("Select...");

        //Clicar no campo ID returning e selecionar o value "select..." ou valor visível
        WebElement returning = navegador.findElement(By.id("returning"));
        new Select(returning).selectByVisibleText("July (two years from now)");

        //Clicar no ID promotional_code e preencher com o valor "AA1-AAA- 124"
        WebElement codeValido = navegador.findElement(By.id("promotional_code"));
        codeValido.sendKeys("AA1-AAA- 124");

        //Clicar no botão "Search" através do xpath
        navegador.findElement(By.xpath("//*[@id=\"content\"]/form/dl[4]/dd")).click();

        //validar a mensagem
        WebElement mensagemTela = navegador.findElement(By.xpath("//*[@id=\"content\"]/p[1]"));
        String mensagem1 = mensagemTela.getText();
        Assert.assertEquals("Sorry, there are no more seats available.", mensagem1);

        //Printar o Resultado
    }

    @Test
    public void testPassagemCupomValidoVazioDecember() {
        //Clicar no campo ID departing e selecionar value Select...
        WebElement departing = navegador.findElement(By.id("departing"));
        new Select(departing).selectByVisibleText("Select...");

        //Clicar no campo ID returning e selecionar o value "select..." ou valor visível
        WebElement returning = navegador.findElement(By.id("returning"));
        new Select(returning).selectByVisibleText("December (two years from now)");

        //Clicar no ID promotional_code e preencher com o valor "AA1-AAA- 124"
        WebElement codeValido = navegador.findElement(By.id("promotional_code"));
        codeValido.sendKeys("AA1-AAA- 124");

        //Clicar no botão "Search" através do xpath
        navegador.findElement(By.xpath("//*[@id=\"content\"]/form/dl[4]/dd")).click();

        //validar a mensagem
        WebElement mensagemTela = navegador.findElement(By.xpath("//*[@id=\"content\"]/p[1]"));
        String mensagem1 = mensagemTela.getText();
        Assert.assertEquals("Sorry, there are no more seats available.", mensagem1);

        //Printar o Resultado
    }

    @Test
    public void testPassagemCupomValidoJulyVazio() {
        //Clicar no campo ID departing e selecionar value Select...
        WebElement departing = navegador.findElement(By.id("departing"));
        new Select(departing).selectByVisibleText("July");

        //Clicar no campo ID returning e selecionar o value "select..." ou valor visível
        WebElement returning = navegador.findElement(By.id("returning"));
        new Select(returning).selectByVisibleText("Select...");

        //Clicar no ID promotional_code e preencher com o valor "AA1-AAA- 124"
        WebElement codeValido = navegador.findElement(By.id("promotional_code"));
        codeValido.sendKeys("AA1-AAA- 124");

        //Clicar no botão "Search" através do xpath
        navegador.findElement(By.xpath("//*[@id=\"content\"]/form/dl[4]/dd")).click();

        //validar a mensagem
        WebElement mensagemTela = navegador.findElement(By.xpath("//*[@id=\"content\"]/p[1]"));
        String mensagem1 = mensagemTela.getText();
        Assert.assertEquals("Sorry, there are no more seats available.", mensagem1);

        //Printar o Resultado
    }

    @Test
    public void testPassagemCupomValidoJulyDecemberTwoYears() {

        //Clicar no campo ID departing e selecionar value Select...
        WebElement departing = navegador.findElement(By.id("departing"));
        new Select(departing).selectByVisibleText("July");

        //Clicar no campo ID returning e selecionar o value "select..." ou valor visível
        WebElement returning = navegador.findElement(By.id("returning"));
        new Select(returning).selectByVisibleText("December (two years from now)");

        //Clicar no ID promotional_code e preencher com o valor "AA1-AAA- 124"
        WebElement codeValido = navegador.findElement(By.id("promotional_code"));
        codeValido.sendKeys("AA1-AAA- 124");

        //Clicar no botão "Search" através do xpath
        navegador.findElement(By.xpath("//*[@id=\"content\"]/form/dl[4]/dd")).click();

        //validar a mensagem
        WebElement mensagemTela = navegador.findElement(By.xpath("//div[@id='content']/p[3]"));
        String mensagem4 = mensagemTela.getText();
        Assert.assertEquals("Call now on 0800 MARSAIR to book!", mensagem4);

        //Printar o Resultado

    }

    @Test
    public void testPassagemCupomValidoDecemberVazio() {
        //Clicar no campo ID departing e selecionar value Select...
        WebElement departing = navegador.findElement(By.id("departing"));
        new Select(departing).selectByVisibleText("December");

        //Clicar no campo ID returning e selecionar o value "select..." ou valor visível
        WebElement returning = navegador.findElement(By.id("returning"));
        new Select(returning).selectByVisibleText("Select...");

        //Clicar no ID promotional_code e preencher com o valor "AA1-AAA- 124"
        WebElement codeValido = navegador.findElement(By.id("promotional_code"));
        codeValido.sendKeys("AA1-AAA- 124");

        //Clicar no botão "Search" através do xpath
        navegador.findElement(By.xpath("//*[@id=\"content\"]/form/dl[4]/dd")).click();

        //validar a mensagem
        WebElement mensagemTela = navegador.findElement(By.xpath("//*[@id=\"content\"]/p[1]"));
        String mensagem1 = mensagemTela.getText();
        Assert.assertEquals("Sorry, there are no more seats available.", mensagem1);

        //Printar o Resultado
    }

        @Test
        public void testPassagemCupomValidoDecemberJulyTwoYearsFromNow() {
            //Clicar no campo ID departing e selecionar value Select...
            WebElement departing = navegador.findElement(By.id("departing"));
            new Select(departing).selectByVisibleText("December");

            //Clicar no campo ID returning e selecionar o value "select..." ou valor visível
            WebElement returning = navegador.findElement(By.id("returning"));
            new Select(returning).selectByVisibleText("July (two years from now)");

            //Clicar no ID promotional_code e preencher com o valor "AA1-AAA- 124"
            WebElement codeValido = navegador.findElement(By.id("promotional_code"));
            codeValido.sendKeys("AA1-AAA- 124");

            //Clicar no botão "Search" através do xpath
            navegador.findElement(By.xpath("//*[@id=\"content\"]/form/dl[4]/dd")).click();

            //validar a mensagem
            WebElement mensagemTela = navegador.findElement(By.xpath("//*[@id=\"content\"]/p[1]"));
            String mensagem1 = mensagemTela.getText();
            Assert.assertEquals("Sorry, there are no more seats available.", mensagem1);

            //Printar o Resultado

        }

    @Test
    public void testPassagemCupomValidoDecemberNextYearVazio() {
        //Clicar no campo ID departing e selecionar value Select...
        WebElement departing = navegador.findElement(By.id("departing"));
        new Select(departing).selectByVisibleText("December (next year)");

        //Clicar no campo ID returning e selecionar o value "select..." ou valor visível
        WebElement returning = navegador.findElement(By.id("returning"));
        new Select(returning).selectByVisibleText("Select...");

        //Clicar no ID promotional_code e preencher com o valor "AA1-AAA- 124"
        WebElement codeValido = navegador.findElement(By.id("promotional_code"));
        codeValido.sendKeys("AA1-AAA- 124");

        //Clicar no botão "Search" através do xpath
        navegador.findElement(By.xpath("//*[@id=\"content\"]/form/dl[4]/dd")).click();

        //validar a mensagem
        WebElement mensagemTela = navegador.findElement(By.xpath("//*[@id=\"content\"]/p[1]"));
        String mensagem1 = mensagemTela.getText();
        Assert.assertEquals("Sorry, there are no more seats available.", mensagem1);

        //Printar o Resultado

    }


    @Test
    public void testPassagemCupomValidoJulyNextYearJulyTwoYears() {
        //Clicar no campo ID departing e selecionar value Select...
        WebElement departing = navegador.findElement(By.id("departing"));
        new Select(departing).selectByVisibleText("July (next year)");

        //Clicar no campo ID returning e selecionar o value "select..." ou valor visível
        WebElement returning = navegador.findElement(By.id("returning"));
        new Select(returning).selectByVisibleText("July (two years from now)");

        //Clicar no ID promotional_code e preencher com o valor "AA1-AAA- 124"
        WebElement codeValido = navegador.findElement(By.id("promotional_code"));
        codeValido.sendKeys("AA1-AAA- 124");

        //Clicar no botão "Search" através do xpath
        navegador.findElement(By.xpath("//*[@id=\"content\"]/form/dl[4]/dd")).click();

        //validar a mensagem
        WebElement mensagemTela = navegador.findElement(By.xpath("//*[@id=\"content\"]/p[1]"));
        String mensagem1 = mensagemTela.getText();
        Assert.assertEquals("Sorry, there are no more seats available.", mensagem1);

        //Printar o Resultado

    }

    @Test
    public void testPassagemCupomValidoDecemberNextYearDecemberTwoYears() {
        //Clicar no campo ID departing e selecionar value Select...
        WebElement departing = navegador.findElement(By.id("departing"));
        new Select(departing).selectByVisibleText("December (next year)");

        //Clicar no campo ID returning e selecionar o value "select..." ou valor visível
        WebElement returning = navegador.findElement(By.id("returning"));
        new Select(returning).selectByVisibleText("December (two years from now)");

        //Clicar no ID promotional_code e preencher com o valor "AA1-AAA- 124"
        WebElement codeValido = navegador.findElement(By.id("promotional_code"));
        codeValido.sendKeys("AA1-AAA- 124");

        //Clicar no botão "Search" através do xpath
        navegador.findElement(By.xpath("//*[@id=\"content\"]/form/dl[4]/dd")).click();

        //validar a mensagem
        WebElement mensagemTela = navegador.findElement(By.xpath("//*[@id=\"content\"]/p[1]"));
        String mensagem1 = mensagemTela.getText();
        Assert.assertEquals("Sorry, there are no more seats available.", mensagem1);

        //Printar o Resultado
    }

    @Test
    public void testPassagemCupomValidoJulyNextYearDecemberTwoYears() {
        //Clicar no campo ID departing e selecionar value Select...
        WebElement departing = navegador.findElement(By.id("departing"));
        new Select(departing).selectByVisibleText("July (next year)");

        //Clicar no campo ID returning e selecionar o value "select..." ou valor visível
        WebElement returning = navegador.findElement(By.id("returning"));
        new Select(returning).selectByVisibleText("December (two years from now)");

        //Clicar no ID promotional_code e preencher com o valor "AA1-AAA- 124"
        WebElement codeValido = navegador.findElement(By.id("promotional_code"));
        codeValido.sendKeys("AA1-AAA- 124");

        //Clicar no botão "Search" através do xpath
        navegador.findElement(By.xpath("//*[@id=\"content\"]/form/dl[4]/dd")).click();

        //validar a mensagem
        WebElement mensagemTela = navegador.findElement(By.xpath("//*[@id=\"content\"]/p[1]"));
        String mensagem1 = mensagemTela.getText();
        Assert.assertEquals("Sorry, there are no more seats available.", mensagem1);

        //Printar o Resultado
    }

    @Test
    public void testPassagemCupomValidoDecemberNextYearJulyTwoYears() {
        //Clicar no campo ID departing e selecionar value Select...
        WebElement departing = navegador.findElement(By.id("departing"));
        new Select(departing).selectByVisibleText("December (next year)");

        //Clicar no campo ID returning e selecionar o value "select..." ou valor visível
        WebElement returning = navegador.findElement(By.id("returning"));
        new Select(returning).selectByVisibleText("July (two years from now)");

        //Clicar no ID promotional_code e preencher com o valor "AA1-AAA- 124"
        WebElement codeValido = navegador.findElement(By.id("promotional_code"));
        codeValido.sendKeys("AA1-AAA- 124");

        //Clicar no botão "Search" através do xpath
        navegador.findElement(By.xpath("//*[@id=\"content\"]/form/dl[4]/dd")).click();

        //validar a mensagem
        WebElement mensagemTela = navegador.findElement(By.xpath("//*[@id=\"content\"]/p[1]"));
        String mensagem3 = mensagemTela.getText();
        Assert.assertEquals("Unfortunately, this schedule is not possible. Please try again.", mensagem3);

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
