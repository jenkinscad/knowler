package everis.suites;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.base.Throwables;
import org.openqa.selenium.chrome.ChromeDriver;
import everis.pages.*;
import everis.Utils;
import everis.actions.*;
import everis.report.Report;
import everis.Application;


public class KnowlerTest {
    
    private By OutlookDeleteEmail = By.xpath("//*[@id='modalExampleId']/div");
    private By EmailsEmployee = By.xpath("//*[@id='0']/ul/li[1]/div[1]");
    private By Area = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-profile/div");
    private By RespnsableName = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[2]/div/div[1]/skmo-team/evc-card/div/div[2]/div/div/div[1]/div[2]/div[1]/div/div[2]/div[1]");
    private By Conatctos = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-social/div/a[1]");
    private By ResponsableCategoria = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-profile/div/div[2]");
    private By ResponsablePrincipal = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[2]/div/div[1]/skmo-team/evc-card/div/div[2]/div/div/div[1]/div[2]/div[1]/div/div[2]/div[1]");
    private By ColleagueArea = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-profile/div/div[4]");
    private By TipoAsset = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[3]/div/ng-component[2]/div/ng-component/div");
    private By ProductoCompana = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[4]/div/ng-component/div/ng-component/div");
    private By ServicioCompania = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[5]/div/ng-component/div/ng-component/a");
    private By ConexionesGrafo = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[2]/div/ng-component[1]/div/ng-component/div/ng-component/div");
    private By CategoraServicio = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[3]/div/ng-component[3]/div/ng-component/div");
    private By IconoDeAsset = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[2]/div/ng-component/div/ng-component/img");
    private By NombreServicio = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[3]/div/ng-component[1]/div/ng-component/div");
    private By ServicesFilter = By.xpath("//*[@id='services']/div/div/div[2]");
    private By AllFilter = By.xpath("//*[@id=\\'all\\']/div/div/div/div[2]/div/span");
    private By FilterDocumentsSmartphone = By.xpath("//*[@id='documents']/div/div/div/div[2]/div/span");
    private By FilterEmployeesSmartphone = By.xpath("//*[@id='employees']/div/div/div[2]");
    private By FilterClientsSmartphone = By.xpath("//*[@id='customeraccounts']/div/div/div/div[2]/div/span");
    private By ProjectsFilter = By.xpath("//*[@id='projects']/div/div/div[2]");
    private By ProductsFilter = By.xpath("//*[@id='products']/div/div/div/div[2]/div/span");
    private By Projects = By.xpath("//*[@id='active']/p-scrollpanel/div/div[1]/div/div[1]/div");
    private By WorkExperience = By.xpath("//*[@id='active']/div/p");
    private By Skills = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/div/div[1]/evc-list/div/div");
    private By ResponsibleName = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[2]/div/div[1]/skmo-team/evc-card/div/div[2]/div/div/div[1]/div[2]/div[1]/div/div[2]/div[1]");
    private By ColleagueName = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[2]/div/div[1]/skmo-team/evc-card/div/div[2]/div/div/p-scrollpanel/div/div[1]/div/div/div/div[2]/div[2]/div[1]");
    private By Foto = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/img");
    private By NameAndSurname = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-profile/div/div[1]");
    private By Categorie = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-profile/div/div[2]");
    private By AreaEmployee = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-profile/div/div[4]");
    private By Ubicacion = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-profile/div/div[3]");
    private By EmailSkype = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-social/div/a[1]");
    private By Date = By.xpath("//*[@id='documents']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[2]/div/div[1]/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[3]/div");
    private By Documents = By.xpath("//*[@id='documents']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[1]/div/div[1]/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[1]/a");
    private By User = By.xpath("//*[@id='documents']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[1]/div/div[1]/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[2]/div");
    private By NombreProducto = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[3]/div/ng-component[1]/div/ng-component/div");
    private By CategoriaProducto = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[3]/div/ng-component[2]/div/ng-component/div");
    private By AssetCompania = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[4]/div/ng-component/div/ng-component/div");
    private By ConexionesGrafo1 = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[5]/div/ng-component/div/ng-component/a");
    private By LineaProducto = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[3]/div/ng-component[3]/div/ng-component/div");
    private By IconoProducto = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[2]/div/ng-component/div/ng-component/img");
    private By ProposalAssistantContainer = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-userhome/div/div/div[2]/div[4]/skmo-widget/div/evc-card/div/div[1]/div[1]/h1");
    private By TeamsContainer = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-userhome/div/div/div[2]/div[3]/skmo-widget/div/evc-card/div/div[1]/div[1]/h1");
    private By DocumentsContainer = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-userhome/div/div/div[4]/div[2]/skmo-widget/div/evc-card");
    private By ProjectsContainer = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-userhome/div/div/div[3]/div[2]/skmo-widget/div/evc-card/div/div[1]/div[1]/h1");
    private By People2MeetContainer = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-userhome/div/div/div[2]/div[2]/skmo-widget/div/evc-card/div/div[1]/div[1]/h1");
    private By SearchContainer = By.xpath("/html/body/main/skmo-app-root/skmo-header/header/div/div[1]/skmo-header-search/div[1]/label");
    private By EventsContainer = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-userhome/div/div/div[2]/div[1]/skmo-widget/div/evc-card/div/div[1]/div[1]/h1");
    private By EmailsContainer = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-userhome/div/div/div[3]/div[1]/skmo-widget/div/evc-card");
    private By ContactsContainer = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-userhome/div/div/div[4]/div[1]/skmo-widget/div/evc-card/div/div[1]/div[1]/h1");
    private By FeaturedDirectorInZaragosa = By.xpath("//*[@id='all']/div/div/div/div[1]/skmo-interpreted-results/div[2]/div");
    private By DirectorInZaragoza = By.xpath("//*[@id='all']/div/div/div/div[1]/skmo-interpreted-results/div[1]/span");
    private By ListDirector = By.xpath("//*[@id='all']/div/div/div/div[1]/skmo-interpreted-results/div[2]/skmo-carousel/div/div/div/ul/li[1]/div/div/div[1]/ng-component/div/ng-component[2]/div/ng-component[1]/div/ng-component[2]/div");
    private By ListDirectorZaragoza = By.xpath("//*[@id='all']/div/div/div/div[1]/skmo-interpreted-results/div[2]/skmo-carousel/div/div/div/ul/li[1]/div/div/div[1]/ng-component/div/ng-component[2]/div/ng-component[1]/div/ng-component[3]/div");
    private By FeaturedMangerZaragosa = By.xpath("//*[@id='all']/div/div/div/div[1]/skmo-interpreted-results/div[2]/div");
    private By MangerZaragosa = By.xpath("//*[@id='all']/div/div/div/div[1]/skmo-interpreted-results/div[1]/span");
    private By ListCardManager = By.xpath("//*[@id='all']/div/div/div/div[1]/skmo-interpreted-results/div[2]/skmo-carousel/div/div/div/ul/li[1]/div/div/div[1]/ng-component/div/ng-component[2]/div/ng-component[1]/div/ng-component[2]/div");
    private By ListCardManagerZaragoza = By.xpath("//*[@id='all']/div/div/div/div[1]/skmo-interpreted-results/div[2]/skmo-carousel/div/div/div/ul/li[1]/div/div/div[1]/ng-component/div/ng-component[2]/div/ng-component[1]/div/ng-component[3]/div");
    private By ProductoCompana1 = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[4]/div/ng-component/div/ng-component/div");
    private By URL = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[5]/div/ng-component/div/ng-component/a");
    private By reaResponsibleDelAsset = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[3]/div/ng-component[3]/div/ng-component/div");
    private By CategoriaAsset = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[3]/div/ng-component[3]/div/ng-component/div");
    private By TipoAsset1 = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[3]/div/ng-component[3]/div/ng-component/div");
    private By NombreAsset = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[3]/div/ng-component[1]/div/ng-component/div");
    private By CodigoAsset = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[3]/div/ng-component[2]/div/ng-component/div");
    private By StartDate = By.xpath("//*[@id='projects']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[1]/div/div/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[3]/div");
    private By CompanyName = By.xpath("//*[@id='projects']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[1]/div/div/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[1]/a");
    private By AreaName = By.xpath("//*[@id='projects']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[1]/div/div/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[2]/div");
    private By DocumentoNome = By.xpath("//*[@id='documents']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[1]/div/div[1]/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[1]/a");
    private By PropietarioNome = By.xpath("//*[@id='documents']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[1]/div/div[1]/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[2]/div");
    private By AssertPalavra = By.xpath("//*[@id='projects']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[1]/div/div/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[3]/div");
    private By DocumentosPorPalavras = By.xpath("//*[@id='documents']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[1]/div/div[1]/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[1]/a");
    private By DocumentoOwner = By.xpath("//*[@id='documents']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[1]/div/div[1]/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[2]/div");
    private By DocuTema = By.xpath("//*[@id='projects']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[1]/div/div/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[3]/div");
    private By DocuName = By.xpath("//*[@id='documents']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[1]/div/div[1]/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[1]/a");
    private By DocuOwner = By.xpath("//*[@id='documents']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[1]/div/div[1]/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[2]/div");
    private By DocumentoNome1 = By.xpath("//*[@id='documents']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[1]/div/div[1]/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[1]/a");
    private By DocumentoOwner1 = By.xpath("//*[@id='documents']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[1]/div/div[1]/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[2]/div");
    private By ListEmployeeProjectsJapon = By.xpath("//*[@id='all']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[1]/div");
    private By DocumentsTab = By.xpath("//*[@id='header-documentsMs']/span");
    private By DocumentsEmpty = By.xpath("//*[@id='documentsMs']/div/div/div[2]");
    private By EmailDate = By.xpath("//*[@id='mails']/div/div/div/div[1]/skmo-entityretrieval-results/div/skmo-element-type-myoffice[1]/div/div/div[1]/div[2]/div");
    private By EmailsTab = By.xpath("//*[@id='mails']/div/div/div/div[1]/div");
    private By EmailName = By.xpath("//*[@id='mails']/div/div/div/div[1]/skmo-entityretrieval-results/div/skmo-element-type-myoffice[1]/div/div/div[1]/div[2]/a");
    private By PersonArea = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-profile/div/div[4]");
    private By PersonLocation = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-profile/div/div[3]");
    private By PersonContacts = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-social/div");
    private By PersonConnections = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-button/a");
    private By PersonPhoto = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/img");
    private By PersonName = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-profile/div/div[1]");
    private By PersonCategory = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-profile/div/div[2]");
    private By AssetType = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[3]/div/ng-component[2]/div/ng-component/div");
    private By GraphConnections = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[2]/div/ng-component[1]/div/ng-component/div/ng-component/div");
    private By AssetIcon = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[2]/div/ng-component/div/ng-component/img");
    private By ServiceName = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[3]/div/ng-component[1]/div/ng-component/div");
    private By CompanyProduct = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[4]/div/ng-component/div/ng-component/div");
    private By CompanyService = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[5]/div/ng-component/div/ng-component/a");
    private By ProfileArea = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-profile/div");
    private By ResponsibleName1 = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[2]/div/div[1]/skmo-team/evc-card/div/div[2]/div/div/div[1]/div[2]/div[1]/div/div[2]/div[1]");
    private By Contacts = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-social/div/a[1]");
    private By Category = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-profile/div/div[2]");
    private By MainResponsible = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[2]/div/div[1]/skmo-team/evc-card/div/div[2]/div/div/div[1]/div[2]/div[1]/div/div[2]/div[1]");
    private By ColleagueArea1 = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-profile/div/div[4]");
    private By ProfileProjectsInProgress = By.xpath("//*[@id='header-active']/span");
    private By ProfileProject1 = By.xpath("//*[@id='active']/p-scrollpanel/div/div[1]/div/div[1]/div/a/span");
    private By ProfileProject2 = By.xpath("//*[@id='active']/p-scrollpanel/div/div[1]/div/div[2]/div/a/span");
    private By ProfileProject3 = By.xpath("//*[@id='active']/p-scrollpanel/div/div[1]/div/div[3]/div/a/span");
    private By ProfileProjectsTitle = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[2]/div/div[1]/skmo-project-widget/div/h1");
    private By OrganizationStatus = By.xpath("//*[@id='0']/div/div[2]/skmo-client-box/div[2]/div/div[4]/span[2]");
    private By OrganizationRelevantTags = By.xpath("//*[@id='0']/div/div[3]/skmo-cloud-tags/div");
    private By OrganizationName = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-client/div/skmo-shared-client/div/skmo-client-intro/div/div/h1");
    private By Project2 = By.xpath("//*[@id='0']/div/div[1]/skmo-client-details/div[2]/div/div[3]/div[10]/div/span[3]");
    private By Project3 = By.xpath("//*[@id='0']/div/div[1]/skmo-client-details/div[2]/div/div[3]/div[10]/div/span[4]");
    private By Project4 = By.xpath("//*[@id='0']/div/div[1]/skmo-client-details/div[2]/div/div[3]/div[10]/div/span[5]");
    private By Project5 = By.xpath("//*[@id='0']/div/div[1]/skmo-client-details/div[2]/div/div[3]/div[10]/div/span[6]");
    private By OrganizationIcon = By.xpath("//*[@id='0']/div/div[1]/skmo-client-details/div[2]/div/div[1]/span");
    private By OrganizationCode = By.xpath("//*[@id='0']/div/div[2]/skmo-client-box/div[2]/div/div[3]/span[2]");
    private By OrganizationSector = By.xpath("//*[@id='0']/div/div[1]/skmo-client-details/div[2]/div/div[3]/div[3]/div/span[2]");
    private By OrganizationResponsible = By.xpath("//*[@id='1']/skmo-client-summary/div/div[2]/div[1]/span");
    private By OrganizationProjectsInProgress = By.xpath("//*[@id='1']/skmo-client-summary/div/div[2]/div[2]/div/span[1]");
    private By Project1 = By.xpath("//*[@id='0']/div/div[1]/skmo-client-details/div[2]/div/div[3]/div[10]/div/span[2]");
    private By ClientsFilter = By.xpath("//*[@id='customeraccounts']/div/div/div/div[2]/div/span");
    private By ProductsFilter1 = By.xpath("//*[@id='products']/div/div/div/div[2]/div/span");
    private By ServicesFilter1 = By.xpath("//*[@id='services']/div/div/div[2]");
    private By AllFilter1 = By.xpath("//*[@id='all']/div/div/div/div[2]/div/span");
    private By EmployeesFilter = By.xpath("//*[@id='employees']/div");
    private By DocumentsFilter = By.xpath("//*[@id='documents']/div/div/div/div[2]/div/span");
    private By ProjectsFilter1 = By.xpath("//*[@id='projects']/div/div/div[2]");
    private By DocumentDate = By.xpath("//*[@id='documents']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[1]/div/div[1]/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[3]/div");
    private By DocumentTitle = By.xpath("//*[@id='documents']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[1]/div/div[1]/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[1]/a");
    private By DocumentUser = By.xpath("//*[@id='documents']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[1]/div/div[1]/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[2]");
    private By Colleague1Category = By.xpath("//*[@id='all']/div/div[2]/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[1]/div/div/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[2]/div");
    private By Colleague3Category = By.xpath("//*[@id='all']/div/div[2]/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[5]/div/div/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[2]/div");
    private By Colleague1Connections = By.xpath("//*[@id='all']/div/div[2]/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[3]/div/div/div[2]/ng-component/div/ng-component/div/ng-component/div/ng-component[4]/a");
    private By Colleague2Connections = By.xpath("//*[@id='all']/div/div[2]/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[3]/div/div/div[2]/ng-component/div/ng-component/div/ng-component/div/ng-component[4]/a");
    private By Colleague3Connections = By.xpath("//*[@id='all']/div/div[2]/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[5]/div/div/div[2]/ng-component/div/ng-component/div/ng-component/div/ng-component[4]/a");
    private By Colleague1FullName = By.xpath("//*[@id='all']/div/div[2]/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[1]/div/div/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[1]/a");
    private By Colleague2FullName = By.xpath("//*[@id='all']/div/div[2]/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[3]/div/div/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[1]/a");
    private By Colleague3FullName = By.xpath("//*[@id='all']/div/div[2]/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[5]/div/div/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[1]/a");
    private By Colleague2Category = By.xpath("//*[@id='all']/div/div[2]/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[3]/div/div/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[2]/div");
    private By EmployeeTeams = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-social/div/a[3]");
    private By EmployeeWorkExperience = By.xpath("//*[@id='active']/div/p");
    private By EmployeePhoto = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/img");
    private By EmployeeSkills = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/div/div[1]/evc-list/div");
    private By EmployeeRecentProjects = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[2]/div/div[1]/skmo-project-widget/div/div");
    private By RecentProjectName = By.xpath("//*[@id='active']/p-scrollpanel/div/div[1]/div/div[1]/div/a/span");
    private By RecentProjectClient = By.xpath("//*[@id='active']/p-scrollpanel/div/div[1]/div/div[1]/div/span[2]");
    private By EmployeeFullName = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-profile/div/div[1]");
    private By EmployeeCategory = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-profile/div/div[2]");
    private By EmployeeArea = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-profile/div/div[4]");
    private By EmployeeLocation = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-profile/div/div[3]");
    private By EmployeeEmail = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-social/div/a[1]");
    private By EmployeeSkype = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-social/div/a[2]");
    private By EmployeeConnectionsGraph = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-button/a");
    private By ResponsibleFullName = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-profile/div/div[1]");
    private By ResponsibleManager = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[2]/div/div[1]/skmo-team/evc-card/div/div[2]/div/div/div[1]/div[2]/div[1]/div/div[2]/div[1]");
    private By ResponsibleCategory = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-profile/div/div[2]");
    private By ResponsibleConnections = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-button/a");
    private By DirectorName = By.xpath("//*[@id='all']/div/div/div/div[1]/skmo-interpreted-results/div[2]/skmo-carousel/div/div/div/ul/li[1]/div/div/div[1]/ng-component/div/ng-component[2]/div/ng-component[1]/div/ng-component[2]/div");
    private By DirectorLocation = By.xpath("//*[@id='all']/div/div/div/div[1]/skmo-interpreted-results/div[2]/skmo-carousel/div/div/div/ul/li[1]/div/div/div[1]/ng-component/div/ng-component[2]/div/ng-component[1]/div/ng-component[3]/div");
    private By FeaturedResult = By.xpath("//*[@id='all']/div/div/div/div[1]/skmo-interpreted-results/div[2]/div");
    private By DirectorResult = By.xpath("//*[@id='all']/div/div/div/div[1]/skmo-interpreted-results/div[1]/span");
    private By FeaturedResult1 = By.xpath("//*[@id='all']/div/div/div/div[1]/skmo-interpreted-results/div[2]/div");
    private By ManagerLocation = By.xpath("//*[@id='all']/div/div/div/div[1]/skmo-interpreted-results/div[2]/skmo-carousel/div/div/div/ul/li[1]/div/div/div[1]/ng-component/div/ng-component[2]/div/ng-component[1]/div/ng-component[3]/div");
    private By ManagerResult = By.xpath("//*[@id='all']/div/div/div/div[1]/skmo-interpreted-results/div[1]/span");
    private By ManagerName = By.xpath("//*[@id='all']/div/div/div/div[1]/skmo-interpreted-results/div[2]/skmo-carousel/div/div/div/ul/li[1]/div/div/div[1]/ng-component/div/ng-component[2]/div/ng-component[1]/div/ng-component[2]/div");
    private By ProductCategory = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[3]/div/ng-component[2]/div/ng-component/div");
    private By ProductLine = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[3]/div/ng-component[3]/div/ng-component/div");
    private By CompanyAsset = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[4]/div/ng-component/div/ng-component/div");
    private By GraphConnections1 = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[5]/div/ng-component/div/ng-component/a");
    private By ProductIcon = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[2]/div/ng-component/div/ng-component/img");
    private By ProductName = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[3]/div/ng-component[1]/div/ng-component/div");
    private By EmployeeArea1 = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-profile/div/div[4]");
    private By EmployeeProfileName = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-profile/div/div[1]");
    private By EmployeeLocation1 = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component/div/ng-component[3]/div/ng-component[4]/div/ng-component/div");
    private By EmployeeNumber = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component/div/ng-component[3]/div/ng-component[2]/div/ng-component/div");
    private By EmployeeType = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component/div/ng-component[7]/div/ng-component/div/ng-component/div");
    private By EmployeeCategory1 = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component/div/ng-component[6]/div/ng-component/div/ng-component/div");
    private By EmployeeWidgetName = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component/div/ng-component[3]/div/ng-component[1]/div/ng-component/div");
    private By AssetCategory = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[3]/div/ng-component[4]/div/ng-component/div");
    private By AssetResponsibleArea = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[4]/div/ng-component/div/ng-component/div");
    private By ProductOrAssetCompany = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[1]/div/ng-component/div/ng-component[2]/div");
    private By Url = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[5]/div/ng-component/div/ng-component/a");
    private By AssetName = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[3]/div/ng-component[1]/div/ng-component/div");
    private By Code = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[3]/div/ng-component[2]/div/ng-component/div");
    private By Type = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[3]/div/ng-component[3]/div/ng-component/div");
    private By EmployeeName = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-profile/div/div[1]");
    private By EmployeeContacts = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-social/div");
    private By EmployeeCategory2 = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-profile/div/div[2]");
    private By EmployeeArea2 = By.xpath("/html/body/main/skmo-app-root/div/div/div/skmo-profile/div/div/div[1]/skmo-user-data/div/div[2]/evc-profile/div/div[4]");
    private By ProjectsTitle = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component/div/ng-component[12]/div/ng-component/div/ng-component/div");
    private By Project11 = By.xpath("//*[@id='all']/div/div[2]/div/div[3]/skmo-entity-results-detail/div/div/ng-component/div/ng-component[13]/div/ng-component[1]/div/ng-component[2]/a");
    private By ProjectsResults = By.xpath("//*[@id='projects']/div/div/div/div[2]/div/span");
    private By ProjectName = By.xpath("//*[@id='projects']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[1]/div/div/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[1]/a");
    private By ProjectArea = By.xpath("//*[@id='projects']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[1]/div/div/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[2]/div");
    private By ProjectStartDate = By.xpath("//*[@id='projects']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[1]/div/div/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[3]/div");
    private By EmployeeName1 = By.xpath("//*[@id='projects']/div/div/div/div[3]/skmo-entity-results-detail/div/div/ng-component[3]/div/ng-component[2]/div/ng-component[1]/div/ng-component[2]/a");
    private By ProjectName1 = By.xpath("//*[@id='projects']/div/div/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[3]/div/ng-component/div/ng-component/div");
    private By ProjectName2 = By.xpath("//*[@id='projects']/div/div/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[3]/div/ng-component/div/ng-component/div");
    private By EmployeeName2 = By.xpath("//*[@id='projects']/div/div/div/div[3]/skmo-entity-results-detail/div/div/ng-component[3]/div/ng-component[2]/div/ng-component[1]/div/ng-component[2]/a");
    private By ProjectName3 = By.xpath("//*[@id='projects']/div/div/div/div[3]/skmo-entity-results-detail/div/div/ng-component[1]/div/ng-component[3]/div/ng-component/div/ng-component/div");
    private By EmployeeName3 = By.xpath("//*[@id='projects']/div/div/div/div[3]/skmo-entity-results-detail/div/div/ng-component[3]/div/ng-component[2]/div/ng-component[1]/div/ng-component[2]/a");
    private By EmployeeName4 = By.xpath("//*[@id='all']/div/div[2]/div/div[2]/skmo-interpreted-results/div/div/div/div[2]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[1]/a");
    private By FeaturedTitle = By.xpath("//*[@id='all']/div/div[2]/div/div[2]/skmo-interpreted-results/div/div/div/div[1]");
    private By AllTitle = By.xpath("//*[@id='header-all']/span");
    private By Employee1Name = By.xpath("//*[@id='all']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[1]/div/div/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[1]/a");
    private By Employee2Name = By.xpath("//*[@id='all']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[2]/div/div/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[1]/a");
    private By Employee3Name = By.xpath("//*[@id='all']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[3]/div/div/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[1]/a");
    private By ResultsTitle = By.xpath("//*[@id='all']/div/div/div/div[2]/div/span");
    private By DocumentName = By.xpath("//*[@id='documents']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler/div/div[1]/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[1]/a");
    private By OwnerName = By.xpath("//*[@id='documents']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler/div/div[1]/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[2]/div");
    private By DocumentName1 = By.xpath("//*[@id='documents']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[1]/div/div[1]/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[1]/a");
    private By DocumentOwner = By.xpath("//*[@id='documents']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[1]/div/div[1]/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[2]/div");
    private By DocumentWord = By.xpath("//*[@id='documents']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[1]/div/div[2]/skmo-snippets/div/div/span[2]/strong");
    private By DocumentTheme = By.xpath("//*[@id='documents']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[5]/div/div[2]/skmo-snippets/div/div[1]/span[2]/strong");
    private By DocumentName2 = By.xpath("//*[@id='documents']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[5]/div/div[1]/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[1]/a");
    private By DocumentOwner1 = By.xpath("//*[@id='documents']/div/div/div/div[2]/skmo-entityretrieval-results/div/skmo-element-type-knowler[5]/div/div[1]/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[2]/div");
    private By DocumentName3 = By.xpath("//*[@id='documents']/div/div/div/div[1]/skmo-interpreted-results/div[2]/skmo-carousel/div/div/div/ul/li[1]/div/div/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[1]/a");
    private By DocumentOwner2 = By.xpath("//*[@id='documents']/div/div/div/div[1]/skmo-interpreted-results/div[2]/skmo-carousel/div/div/div/ul/li[1]/div/div/div[1]/ng-component/div/ng-component[2]/div/ng-component/div/ng-component[2]/div");
    
    public static FileSystem fileSystem = FileSystems.getDefault();
    private HashMap<String, ArrayList<HashMap<String, String>>> sheets;
    private WebDriver driver;
    private Properties prop;
    private String level;
    private Logger logger = Utils.logger();
    Map<String, WebDriver> contextsDriver = new HashMap<String, WebDriver>();
    Application a = new Application();
	String className = this.getClass().getSimpleName();
    File folderTestSuite = new File(a.folderLogs + fileSystem.getSeparator() + className);
    String handler;
    
    private ClickFirstEmailPage clickFirstEmailPage;
private GoToProfilePage goToProfilePage;
private Finder1Page finder1Page;
private ViewProfilePage viewProfilePage;
private BackProfilePage backProfilePage;
private FinderPage finderPage;
private FilterServicesPage filterServicesPage;
private FilterDocumentsPage filterDocumentsPage;
private FilterEmployeesPage filterEmployeesPage;
private FilterClientsPage filterClientsPage;
private FilterPprojectsPage filterPprojectsPage;
private FilterProductsPage filterProductsPage;
private DocumentsPage documentsPage;
private ProjectsPage projectsPage;
private DocumentosPage documentosPage;
private Finder2Page finder2Page;
private Finder3Page finder3Page;
private Finder4Page finder4Page;
private FinderEmployeePage finderEmployeePage;
private ChangeSearchTypePage changeSearchTypePage;
private SearchMyOffice365Page searchMyOffice365Page;
private ClickEmailPage clickEmailPage;
private SelectDocumentsTabPage selectDocumentsTabPage;
private EmployeesTabPage employeesTabPage;
private FinderAssetPage finderAssetPage;
private ReturnToSearchPage returnToSearchPage;
private ViewProfileResponsiblePage viewProfileResponsiblePage;
private ViewProfileColleaguePage viewProfileColleaguePage;
private FinderOrganizationPage finderOrganizationPage;
private ScrollDownPage scrollDownPage;
private FinderSmartphonePage finderSmartphonePage;
private SelectEmployeesTabPage selectEmployeesTabPage;
private SelectClientsTabPage selectClientsTabPage;
private SelectProjectsTabPage selectProjectsTabPage;
private SelectProductsTabPage selectProductsTabPage;
private SelectServicesTabPage selectServicesTabPage;
private FinderDocFromUserPage finderDocFromUserPage;
private BackToEmployeeProfilePage backToEmployeeProfilePage;
private FinderDirectorZaragozaPage finderDirectorZaragozaPage;
private FinderManagerZaragozaPage finderManagerZaragozaPage;
private FinderProductPage finderProductPage;
private FinderWidgetPage finderWidgetPage;
private SelectSecondProjectPage selectSecondProjectPage;
private MoveToAssetProjectsPage moveToAssetProjectsPage;
private SelectFirstProjectPage selectFirstProjectPage;
private SelectThirdProjectPage selectThirdProjectPage;
private FinderEmployeeProjectsPage finderEmployeeProjectsPage;
private DocumentsTabPage documentsTabPage;
private FinderDocByNamePage finderDocByNamePage;
private FinderDocByWordPage finderDocByWordPage;
private FindDocByThemePage findDocByThemePage;
private FindDocByOwnerPage findDocByOwnerPage;

    private KnowlerLogInAction knowlerLogInAction;
private EnglishAction englishAction;
private FinderProfileAction finderProfileAction;

    
    private WebDriver MAIN_CONTEXT;
    private File folderDownloads;

    
    
    public WebDriver setUpEnvironment(File folderDownloads, Properties prop, String nameDriver, Map<String, WebDriver> contextsDriver) throws Exception {
        driver = Utils.setUpDriver(folderDownloads, prop, nameDriver, contextsDriver);
        
        handler = driver.getWindowHandle();
        clickFirstEmailPage = new ClickFirstEmailPage(driver);
goToProfilePage = new GoToProfilePage(driver);
finder1Page = new Finder1Page(driver);
viewProfilePage = new ViewProfilePage(driver);
backProfilePage = new BackProfilePage(driver);
finderPage = new FinderPage(driver);
filterServicesPage = new FilterServicesPage(driver);
filterDocumentsPage = new FilterDocumentsPage(driver);
filterEmployeesPage = new FilterEmployeesPage(driver);
filterClientsPage = new FilterClientsPage(driver);
filterPprojectsPage = new FilterPprojectsPage(driver);
filterProductsPage = new FilterProductsPage(driver);
documentsPage = new DocumentsPage(driver);
projectsPage = new ProjectsPage(driver);
documentosPage = new DocumentosPage(driver);
finder2Page = new Finder2Page(driver);
finder3Page = new Finder3Page(driver);
finder4Page = new Finder4Page(driver);
finderEmployeePage = new FinderEmployeePage(driver);
changeSearchTypePage = new ChangeSearchTypePage(driver);
searchMyOffice365Page = new SearchMyOffice365Page(driver);
clickEmailPage = new ClickEmailPage(driver);
selectDocumentsTabPage = new SelectDocumentsTabPage(driver);
employeesTabPage = new EmployeesTabPage(driver);
finderAssetPage = new FinderAssetPage(driver);
returnToSearchPage = new ReturnToSearchPage(driver);
viewProfileResponsiblePage = new ViewProfileResponsiblePage(driver);
viewProfileColleaguePage = new ViewProfileColleaguePage(driver);
finderOrganizationPage = new FinderOrganizationPage(driver);
scrollDownPage = new ScrollDownPage(driver);
finderSmartphonePage = new FinderSmartphonePage(driver);
selectEmployeesTabPage = new SelectEmployeesTabPage(driver);
selectClientsTabPage = new SelectClientsTabPage(driver);
selectProjectsTabPage = new SelectProjectsTabPage(driver);
selectProductsTabPage = new SelectProductsTabPage(driver);
selectServicesTabPage = new SelectServicesTabPage(driver);
finderDocFromUserPage = new FinderDocFromUserPage(driver);
backToEmployeeProfilePage = new BackToEmployeeProfilePage(driver);
finderDirectorZaragozaPage = new FinderDirectorZaragozaPage(driver);
finderManagerZaragozaPage = new FinderManagerZaragozaPage(driver);
finderProductPage = new FinderProductPage(driver);
finderWidgetPage = new FinderWidgetPage(driver);
selectSecondProjectPage = new SelectSecondProjectPage(driver);
moveToAssetProjectsPage = new MoveToAssetProjectsPage(driver);
selectFirstProjectPage = new SelectFirstProjectPage(driver);
selectThirdProjectPage = new SelectThirdProjectPage(driver);
finderEmployeeProjectsPage = new FinderEmployeeProjectsPage(driver);
documentsTabPage = new DocumentsTabPage(driver);
finderDocByNamePage = new FinderDocByNamePage(driver);
finderDocByWordPage = new FinderDocByWordPage(driver);
findDocByThemePage = new FindDocByThemePage(driver);
findDocByOwnerPage = new FindDocByOwnerPage(driver);

        
        knowlerLogInAction = new KnowlerLogInAction(driver);
englishAction = new EnglishAction(driver);
finderProfileAction = new FinderProfileAction(driver);


        return driver;
    }
    
    @Before
    public void setUp() throws Exception {
        folderTestSuite.mkdirs();
        prop = new Properties();
        prop.load(new FileInputStream("config.properties"));
        sheets = Utils.readExcel(prop.getProperty("EXCEL"));
        level = prop.getProperty("LOG_LEVEL");
    }

    @Test
    public void test() throws Exception {
        RDDFPrPeEmp01();
        
        RDDFPrPeTea01();
        
        RDDFPrEnAss01();
        
        RDDFPrFiVer01();
        
        RDDFPrMiPer02();
        
        PSFUTKINDAT02();
        
        RDDFPrEnPro01();
        
        RDDFPrPeCon03();
        
        KnowlerPage();
        
        RDDFPrPeCat05MD();
        
        RDDFPrAsInf01();
        
        RDDFPrPeCol01();
        
        RDDFPrSuSub01();
        
        RDDFPrPeOfi01();
        
        RuiRDDFPrPeEmp01();
        
        RuiRDDFPrCaPer02();
        
        RuiRDDFPrEnAss01();
        
        RuiRDDFPrPeTea01();
        
        RuiRDDFPrPePro01();
        
        RuiRDDFPrMiOrg05();
        
        RuiRDDFPrFiVer01();
        
        RuiPSFUTKINDAT02();
        
        RuiRDDFPrMiPer02();
        
        RuiRDDFPrPeCat05MD();
        
        RuiRDDFPrEnPro01();
        
        RuiRDDFPrPeInf01();
        
        RuiRDDFPrAsInf01();
        
        RuiKORDDFPrPeSki01();
        
        RuiKORDDFPrPeRes01();
        
        RuiRDDFPrPeCon03();
        
        RuiRDDFPrPeCol01();
        
        RuiKORDDFPrPeEdu01();
        
        RuiRDDFPrPeOfi01();
        
        RuiRDDFPrSuSub01();
        
    }

    @After
    public void tearDown() throws Exception {
        Report.reportExcel(folderTestSuite);
    }

    private void RDDFPrPeEmp01() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RDDFPrPeEmp01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeEmp01", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeEmp01", "Action KnowlerLogInAction finished","INFO", level, 10000, driver);
            Thread.sleep(10000);
            Assert.assertTrue("Field EmailsEmployee not found in assertion", driver.findElement(EmailsEmployee).getAttribute("class") != null);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeEmp01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeEmp01", "The field AssertEmployee has been found on assertions", "INFO", level, 0, driver);
            clickFirstEmailPage.clickClickEmail();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeEmp01", "Clicked ClickEmail", "INFO", level, 0, driver);
            Assert.assertTrue("Field OutlookDeleteEmail not found in assertion", driver.findElement(OutlookDeleteEmail).getText().contains("Delete"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeEmp01", "The field Delete has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeEmp01", "The field OpenOutlook has been found on assertions", "INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeEmp01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeEmp01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeEmp01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeEmp01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RDDFPrPeEmp01"+ ":" + finalResult);
        Report.addResults("Knowler", "RDDFPrPeEmp01", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RDDFPrPeEmp01", "Result on RDDFPrPeEmp01: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void RDDFPrPeTea01() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RDDFPrPeTea01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeTea01", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeTea01", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            englishAction.doEnglishAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeTea01", "Action EnglishAction finished","INFO", level, 0, driver);
            finder1Page.setEmployeeName("Sergio Perales Vidal");
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeTea01", "Typed " + "Sergio Perales Vidal" + " in EmployeeName", "INFO", level, 0, driver);
            finder1Page.clickFinderEmployee();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeTea01", "Clicked FinderEmployee", "INFO", level, 0, driver);
            goToProfilePage.clickClickGoToProfile();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeTea01", "Clicked ClickGoToProfile", "INFO", level, 0, driver);
            Assert.assertTrue("Field Area not found in assertion", driver.findElement(Area).getText().contains("Innovation"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeTea01", "The field Innovation has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field RespnsableName not found in assertion", driver.findElement(RespnsableName).getText().contains("Carlos Galve Pellicero"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeTea01", "The field Carlos Galve Pellicero has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeTea01", "The field AssertArea has been found on assertions", "INFO", level, 0, driver);
            viewProfilePage.clickClickViewProfile();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeTea01", "Clicked ClickViewProfile", "INFO", level, 0, driver);
            Assert.assertTrue("Field Conatctos not found in assertion", driver.findElement(Conatctos).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeTea01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ResponsableCategoria not found in assertion", driver.findElement(ResponsableCategoria).getText().contains("Project Leader"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeTea01", "The field Project Leader has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ResponsablePrincipal not found in assertion", driver.findElement(ResponsablePrincipal).getText().contains("Javier Fernandez Luis"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeTea01", "The field Javier Fernandez Luis has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeTea01", "The field AssertCargoResponsable has been found on assertions", "INFO", level, 0, driver);
            backProfilePage.clickBack();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeTea01", "Clicked Back", "INFO", level, 0, driver);
            goToProfilePage.clickClickGoToProfile1();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeTea01", "Clicked ClickGoToProfile1", "INFO", level, 0, driver);
            goToProfilePage.clickClickColleagueProfile();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeTea01", "Clicked ClickColleagueProfile", "INFO", level, 5000, driver);
            Thread.sleep(5000);
            Assert.assertTrue("Field ColleagueArea not found in assertion", driver.findElement(ColleagueArea).getText().contains("Innovation"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeTea01", "The field Innovation has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeTea01", "The field AssertAreaColleague has been found on assertions", "INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeTea01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeTea01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeTea01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeTea01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RDDFPrPeTea01"+ ":" + finalResult);
        Report.addResults("Knowler", "RDDFPrPeTea01", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RDDFPrPeTea01", "Result on RDDFPrPeTea01: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void RDDFPrEnAss01() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RDDFPrEnAss01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnAss01", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnAss01", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            finderPage.setAssetAssert("Implementation of Knowter");
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnAss01", "Typed " + "Implementation of Knowter" + " in AssetAssert", "INFO", level, 0, driver);
            finderPage.clickFinder();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnAss01", "Clicked Finder", "INFO", level, 0, driver);
            Assert.assertTrue("Field TipoAsset not found in assertion", driver.findElement(TipoAsset).getText().contains("112"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnAss01", "The field 112 has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ProductoCompana not found in assertion", driver.findElement(ProductoCompana).getText().contains("Vivamus sed tortor gravida"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnAss01", "The field Vivamus sed tortor gravida has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ServicioCompania not found in assertion", driver.findElement(ServicioCompania).getText().contains("Go to profile"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnAss01", "The field Go to profile has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ConexionesGrafo not found in assertion", "Related Products".equals(driver.findElement(ConexionesGrafo).getText()));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnAss01", "The field Related Products has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field CategoraServicio not found in assertion", driver.findElement(CategoraServicio).getText().contains("Implementation sercices"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnAss01", "The field Implementation sercices has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field IconoDeAsset not found in assertion", driver.findElement(IconoDeAsset).getAttribute("src").contains("assets/images/icons/search/product.svg"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnAss01", "The field assets/images/icons/search/product.svg has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field NombreServicio not found in assertion", driver.findElement(NombreServicio).getText().contains("Implementation of Knowter"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnAss01", "The field Implementation of Knowter has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnAss01", "The field AssertAsset has been found on assertions", "INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnAss01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrEnAss01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnAss01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrEnAss01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RDDFPrEnAss01"+ ":" + finalResult);
        Report.addResults("Knowler", "RDDFPrEnAss01", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RDDFPrEnAss01", "Result on RDDFPrEnAss01: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void RDDFPrFiVer01() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RDDFPrFiVer01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            finderPage.setProductoFinder("Smartphone");
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", "Typed " + "Smartphone" + " in ProductoFinder", "INFO", level, 0, driver);
            finderPage.clickFinder1();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", "Clicked Finder1", "INFO", level, 0, driver);
            Assert.assertTrue("Field AllFilter not found in assertion", driver.findElement(AllFilter).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", "The field AssertAllSmartphone has been found on assertions", "INFO", level, 0, driver);
            filterEmployeesPage.clickClickEmployees();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", "Clicked ClickEmployees", "INFO", level, 0, driver);
            Assert.assertTrue("Field FilterEmployeesSmartphone not found in assertion", driver.findElement(FilterEmployeesSmartphone).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", "The field AssertEmployees has been found on assertions", "INFO", level, 0, driver);
            filterDocumentsPage.clickClickDocuments();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", "Clicked ClickDocuments", "INFO", level, 0, driver);
            Assert.assertTrue("Field FilterDocumentsSmartphone not found in assertion", driver.findElement(FilterDocumentsSmartphone).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", "The field AssertDocuments has been found on assertions", "INFO", level, 0, driver);
            filterClientsPage.clickClickClients();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", "Clicked ClickClients", "INFO", level, 0, driver);
            Assert.assertTrue("Field FilterClientsSmartphone not found in assertion", driver.findElement(FilterClientsSmartphone).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", "The field AssertClients has been found on assertions", "INFO", level, 0, driver);
            filterPprojectsPage.clickClickProjects();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", "Clicked ClickProjects", "INFO", level, 0, driver);
            Assert.assertTrue("Field ProjectsFilter not found in assertion", driver.findElement(ProjectsFilter).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", "The field AssertSmartphoneProjects has been found on assertions", "INFO", level, 0, driver);
            filterProductsPage.clickClickProducts();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", "Clicked ClickProducts", "INFO", level, 0, driver);
            Assert.assertTrue("Field ProductsFilter not found in assertion", driver.findElement(ProductsFilter).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", "The field AssertSmartphoneProducts has been found on assertions", "INFO", level, 0, driver);
            filterServicesPage.clickClickServices();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", "Clicked ClickServices", "INFO", level, 0, driver);
            Assert.assertTrue("Field ServicesFilter not found in assertion", driver.findElement(ServicesFilter).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", "The field AssertSmartphoneServices has been found on assertions", "INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrFiVer01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrFiVer01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RDDFPrFiVer01"+ ":" + finalResult);
        Report.addResults("Knowler", "RDDFPrFiVer01", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", "Result on RDDFPrFiVer01: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void RDDFPrMiPer02() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RDDFPrMiPer02";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrMiPer02", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrMiPer02", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            englishAction.doEnglishAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrMiPer02", "Action EnglishAction finished","INFO", level, 0, driver);
            finder1Page.setEmployeeName1("Sergio Perales Vidal");
            Report.reportLog(finalResult, folderTestCase, "RDDFPrMiPer02", "Typed " + "Sergio Perales Vidal" + " in EmployeeName1", "INFO", level, 0, driver);
            finder1Page.clickFinderEmployee1();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrMiPer02", "Clicked FinderEmployee1", "INFO", level, 0, driver);
            goToProfilePage.clickClickGoToProfile2();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrMiPer02", "Clicked ClickGoToProfile2", "INFO", level, 0, driver);
            Assert.assertTrue("Field Projects not found in assertion", driver.findElement(Projects).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrMiPer02", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field WorkExperience not found in assertion", driver.findElement(WorkExperience).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrMiPer02", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field Skills not found in assertion", driver.findElement(Skills).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrMiPer02", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ResponsibleName not found in assertion", driver.findElement(ResponsibleName).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrMiPer02", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ColleagueName not found in assertion", driver.findElement(ColleagueName).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrMiPer02", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field Foto not found in assertion", driver.findElement(Foto).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrMiPer02", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field NameAndSurname not found in assertion", driver.findElement(NameAndSurname).getText().contains("Sergio Perales Vidal"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrMiPer02", "The field Sergio Perales Vidal has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field Categorie not found in assertion", driver.findElement(Categorie).getText().contains("System Analyst"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrMiPer02", "The field System Analyst has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field AreaEmployee not found in assertion", driver.findElement(AreaEmployee).getText().contains("Innovation"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrMiPer02", "The field Innovation has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field Ubicacion not found in assertion", driver.findElement(Ubicacion).getText().contains("Zaragoza "));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrMiPer02", "The field Zaragoza  has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field EmailSkype not found in assertion", driver.findElement(EmailSkype).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrMiPer02", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrMiPer02", "The field EmployeeData has been found on assertions", "INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrMiPer02", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrMiPer02", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrMiPer02", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrMiPer02", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RDDFPrMiPer02"+ ":" + finalResult);
        Report.addResults("Knowler", "RDDFPrMiPer02", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RDDFPrMiPer02", "Result on RDDFPrMiPer02: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void PSFUTKINDAT02() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "PSFUTKINDAT02";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "PSFUTKINDAT02", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "PSFUTKINDAT02", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            finderPage.setDocumentsFromEmployee("Documentos de Sergio Perales Vidal");
            Report.reportLog(finalResult, folderTestCase, "PSFUTKINDAT02", "Typed " + "Documentos de Sergio Perales Vidal" + " in DocumentsFromEmployee", "INFO", level, 0, driver);
            finderPage.clickFindeDocFromUser();
            Report.reportLog(finalResult, folderTestCase, "PSFUTKINDAT02", "Clicked FindeDocFromUser", "INFO", level, 0, driver);
            documentsPage.clickClickDocuments1();
            Report.reportLog(finalResult, folderTestCase, "PSFUTKINDAT02", "Clicked ClickDocuments1", "INFO", level, 0, driver);
            Assert.assertTrue("Field Date not found in assertion", driver.findElement(Date).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "PSFUTKINDAT02", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field Documents not found in assertion", driver.findElement(Documents).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "PSFUTKINDAT02", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field User not found in assertion", driver.findElement(User).getText().contains("Sergio Perales Vidal"));
            Report.reportLog(finalResult, folderTestCase, "PSFUTKINDAT02", "The field Sergio Perales Vidal has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "PSFUTKINDAT02", "The field AssertDocFromUser has been found on assertions", "INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "PSFUTKINDAT02", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"PSFUTKINDAT02", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "PSFUTKINDAT02", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"PSFUTKINDAT02", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on PSFUTKINDAT02"+ ":" + finalResult);
        Report.addResults("Knowler", "PSFUTKINDAT02", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "PSFUTKINDAT02", "Result on PSFUTKINDAT02: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void RDDFPrEnPro01() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RDDFPrEnPro01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnPro01", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnPro01", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            finderPage.setAssetAssert1("Knowtech Smartphone Serie 0");
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnPro01", "Typed " + "Knowtech Smartphone Serie 0" + " in AssetAssert1", "INFO", level, 0, driver);
            finderPage.clickFinder2();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnPro01", "Clicked Finder2", "INFO", level, 0, driver);
            Assert.assertTrue("Field NombreProducto not found in assertion", driver.findElement(NombreProducto).getText().contains("Knowtech Smartphone Serie 0"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnPro01", "The field Knowtech Smartphone Serie 0 has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field CategoriaProducto not found in assertion", driver.findElement(CategoriaProducto).getText().contains("96"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnPro01", "The field 96 has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field AssetCompania not found in assertion", driver.findElement(AssetCompania).getText().contains("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam tempus justo ex, ut vestibulum nunc iaculis non."));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnPro01", "The field Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam tempus justo ex, ut vestibulum nunc iaculis non. has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ConexionesGrafo1 not found in assertion", driver.findElement(ConexionesGrafo1).getText().contains("Go to profile"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnPro01", "The field Go to profile has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field LineaProducto not found in assertion", driver.findElement(LineaProducto).getText().contains("Smartphone"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnPro01", "The field Smartphone has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field IconoProducto not found in assertion", driver.findElement(IconoProducto).getAttribute("src").contains("assets/images/icons/search/product.svg"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnPro01", "The field assets/images/icons/search/product.svg has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnPro01", "The field AssertProducto has been found on assertions", "INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnPro01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrEnPro01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnPro01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrEnPro01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RDDFPrEnPro01"+ ":" + finalResult);
        Report.addResults("Knowler", "RDDFPrEnPro01", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RDDFPrEnPro01", "Result on RDDFPrEnPro01: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void RDDFPrPeCon03() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RDDFPrPeCon03";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCon03", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCon03", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            englishAction.doEnglishAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCon03", "Action EnglishAction finished","INFO", level, 0, driver);
            finderPage.setEmployeeName2("Sergio Perales Vidal");
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCon03", "Typed " + "Sergio Perales Vidal" + " in EmployeeName2", "INFO", level, 0, driver);
            finderPage.clickFinderEmployee2();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCon03", "Clicked FinderEmployee2", "INFO", level, 0, driver);
            goToProfilePage.clickClickGoToProfile3();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCon03", "Clicked ClickGoToProfile3", "INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCon03", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeCon03", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCon03", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeCon03", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RDDFPrPeCon03"+ ":" + finalResult);
        Report.addResults("Knowler", "RDDFPrPeCon03", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCon03", "Result on RDDFPrPeCon03: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void KnowlerPage() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "KnowlerPage";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "KnowlerPage", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "KnowlerPage", "Action KnowlerLogInAction finished","INFO", level, 10000, driver);
            Thread.sleep(10000);
            Assert.assertTrue("Field ProposalAssistantContainer not found in assertion", driver.findElement(ProposalAssistantContainer).getText().contains("Proposal Assistant"));
            Report.reportLog(finalResult, folderTestCase, "KnowlerPage", "The field Proposal Assistant has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field TeamsContainer not found in assertion", driver.findElement(TeamsContainer).getText().contains("Teams"));
            Report.reportLog(finalResult, folderTestCase, "KnowlerPage", "The field Teams has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field DocumentsContainer not found in assertion", driver.findElement(DocumentsContainer).getAttribute("class").contains("skmo-card skmo-card--full-width Documentos a la vista"));
            Report.reportLog(finalResult, folderTestCase, "KnowlerPage", "The field skmo-card skmo-card--full-width Documentos a la vista has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ProjectsContainer not found in assertion", driver.findElement(ProjectsContainer).getText().contains("Proyectos"));
            Report.reportLog(finalResult, folderTestCase, "KnowlerPage", "The field Proyectos has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field People2MeetContainer not found in assertion", driver.findElement(People2MeetContainer).getText().contains("People2Meet"));
            Report.reportLog(finalResult, folderTestCase, "KnowlerPage", "The field People2Meet has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field SearchContainer not found in assertion", driver.findElement(SearchContainer).getAttribute("for").contains("search-input"));
            Report.reportLog(finalResult, folderTestCase, "KnowlerPage", "The field search-input has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field EventsContainer not found in assertion", driver.findElement(EventsContainer).getText().contains("Eventos"));
            Report.reportLog(finalResult, folderTestCase, "KnowlerPage", "The field Eventos has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field EmailsContainer not found in assertion", driver.findElement(EmailsContainer).getAttribute("class").contains("skmo-card skmo-card--full-width E-mails"));
            Report.reportLog(finalResult, folderTestCase, "KnowlerPage", "The field skmo-card skmo-card--full-width E-mails has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ContactsContainer not found in assertion", driver.findElement(ContactsContainer).getText().contains("Contactos"));
            Report.reportLog(finalResult, folderTestCase, "KnowlerPage", "The field Contactos has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "KnowlerPage", "The field AssertKnowlerPageWidget has been found on assertions", "INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "KnowlerPage", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"KnowlerPage", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "KnowlerPage", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"KnowlerPage", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on KnowlerPage"+ ":" + finalResult);
        Report.addResults("Knowler", "KnowlerPage", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "KnowlerPage", "Result on KnowlerPage: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void RDDFPrPeCat05MD() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RDDFPrPeCat05MD";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCat05MD", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCat05MD", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            finderPage.setManagerZaragozaAssert("Manager Zaragoza");
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCat05MD", "Typed " + "Manager Zaragoza" + " in ManagerZaragozaAssert", "INFO", level, 0, driver);
            finderPage.clickFinderManagerZaragoza();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCat05MD", "Clicked FinderManagerZaragoza", "INFO", level, 0, driver);
            Assert.assertTrue("Field FeaturedMangerZaragosa not found in assertion", driver.findElement(FeaturedMangerZaragosa).getText().contains("Featured"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCat05MD", "The field Featured has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field MangerZaragosa not found in assertion", driver.findElement(MangerZaragosa).getText().contains("Manager Zaragoza"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCat05MD", "The field Manager Zaragoza has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ListCardManager not found in assertion", driver.findElement(ListCardManager).getText().contains("Manager"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCat05MD", "The field Manager has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ListCardManagerZaragoza not found in assertion", driver.findElement(ListCardManagerZaragoza).getText().contains("Zaragoza, Spain"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCat05MD", "The field Zaragoza, Spain has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCat05MD", "The field AssertManagerZaragoza has been found on assertions", "INFO", level, 0, driver);
            finderPage.setDirectorInZaragozaAssert("Director Zaragoza");
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCat05MD", "Typed " + "Director Zaragoza" + " in DirectorInZaragozaAssert", "INFO", level, 0, driver);
            finderPage.clickDirectorZaragoza();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCat05MD", "Clicked DirectorZaragoza", "INFO", level, 0, driver);
            Assert.assertTrue("Field FeaturedDirectorInZaragosa not found in assertion", driver.findElement(FeaturedDirectorInZaragosa).getText().contains("Featured"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCat05MD", "The field Featured has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field DirectorInZaragoza not found in assertion", driver.findElement(DirectorInZaragoza).getText().contains("Director Zaragoza"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCat05MD", "The field Director Zaragoza has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ListDirector not found in assertion", driver.findElement(ListDirector).getText().contains("Director"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCat05MD", "The field Director has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ListDirectorZaragoza not found in assertion", driver.findElement(ListDirectorZaragoza).getText().contains("Zaragoza, Spain"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCat05MD", "The field Zaragoza, Spain has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCat05MD", "The field DirectorZaragoza1 has been found on assertions", "INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCat05MD", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeCat05MD", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCat05MD", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeCat05MD", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RDDFPrPeCat05MD"+ ":" + finalResult);
        Report.addResults("Knowler", "RDDFPrPeCat05MD", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCat05MD", "Result on RDDFPrPeCat05MD: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void RDDFPrAsInf01() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RDDFPrAsInf01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrAsInf01", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrAsInf01", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            finderPage.setAssetAssert2("Implementation of Knowter");
            Report.reportLog(finalResult, folderTestCase, "RDDFPrAsInf01", "Typed " + "Implementation of Knowter" + " in AssetAssert2", "INFO", level, 0, driver);
            finderPage.clickFinder3();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrAsInf01", "Clicked Finder3", "INFO", level, 0, driver);
            Assert.assertTrue("Field ProductoCompana1 not found in assertion", driver.findElement(ProductoCompana1).getText().contains("Vivamus sed tortor gravida"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrAsInf01", "The field Vivamus sed tortor gravida has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field URL not found in assertion", driver.findElement(URL).getText().contains("Go to profile"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrAsInf01", "The field Go to profile has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field reaResponsibleDelAsset not found in assertion", driver.findElement(reaResponsibleDelAsset).getText().contains("Implementation sercices"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrAsInf01", "The field Implementation sercices has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field CategoriaAsset not found in assertion", driver.findElement(CategoriaAsset).getText().contains("Implementation sercices"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrAsInf01", "The field Implementation sercices has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field TipoAsset1 not found in assertion", driver.findElement(TipoAsset1).getText().contains("Implementation sercices"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrAsInf01", "The field Implementation sercices has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field NombreAsset not found in assertion", driver.findElement(NombreAsset).getText().contains("Implementation of Knowter"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrAsInf01", "The field Implementation of Knowter has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field CodigoAsset not found in assertion", driver.findElement(CodigoAsset).getText().contains("112"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrAsInf01", "The field 112 has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrAsInf01", "The field AssertWidget has been found on assertions", "INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrAsInf01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrAsInf01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrAsInf01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrAsInf01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RDDFPrAsInf01"+ ":" + finalResult);
        Report.addResults("Knowler", "RDDFPrAsInf01", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RDDFPrAsInf01", "Result on RDDFPrAsInf01: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void RDDFPrPeCol01() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RDDFPrPeCol01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCol01", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCol01", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            finderPage.setEmployee("Bruno Dalicandro Bedin");
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCol01", "Typed " + "Bruno Dalicandro Bedin" + " in Employee", "INFO", level, 0, driver);
            finderPage.clickFinderProjects();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCol01", "Clicked FinderProjects", "INFO", level, 0, driver);
            projectsPage.clickClickProjects1();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCol01", "Clicked ClickProjects1", "INFO", level, 0, driver);
            Assert.assertTrue("Field StartDate not found in assertion", driver.findElement(StartDate).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCol01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field CompanyName not found in assertion", driver.findElement(CompanyName).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCol01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field AreaName not found in assertion", driver.findElement(AreaName).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCol01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCol01", "The field AssertProjects has been found on assertions", "INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCol01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeCol01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCol01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeCol01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RDDFPrPeCol01"+ ":" + finalResult);
        Report.addResults("Knowler", "RDDFPrPeCol01", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCol01", "Result on RDDFPrPeCol01: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void RDDFPrSuSub01() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RDDFPrSuSub01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            englishAction.doEnglishAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "Action EnglishAction finished","INFO", level, 0, driver);
            finder1Page.setDocNome("helder_onedrive.docx");
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "Typed " + "helder_onedrive.docx" + " in DocNome", "INFO", level, 0, driver);
            finder1Page.clickFinderDocNome();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "Clicked FinderDocNome", "INFO", level, 0, driver);
            documentosPage.clickClickDocumentos1();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "Clicked ClickDocumentos1", "INFO", level, 0, driver);
            Assert.assertTrue("Field DocumentoNome not found in assertion", driver.findElement(DocumentoNome).getText().contains("helder_onedrive.docx"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "The field helder_onedrive.docx has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field PropietarioNome not found in assertion", driver.findElement(PropietarioNome).getText().contains("Sergio Perales Vidal"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "The field Sergio Perales Vidal has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "The field AssertDocNome has been found on assertions", "INFO", level, 0, driver);
            finder2Page.setDocumentoPorPalavra("Helder");
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "Typed " + "Helder" + " in DocumentoPorPalavra", "INFO", level, 0, driver);
            finder2Page.clickFinderDocPalavra();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "Clicked FinderDocPalavra", "INFO", level, 0, driver);
            documentosPage.clickClickDocumentos2();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "Clicked ClickDocumentos2", "INFO", level, 0, driver);
            Assert.assertTrue("Field AssertPalavra not found in assertion", driver.findElement(AssertPalavra).getText().contains("Helder"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "The field Helder has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field DocumentosPorPalavras not found in assertion", driver.findElement(DocumentosPorPalavras).getText().contains("helder_onedrive.docx"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "The field helder_onedrive.docx has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field DocumentoOwner not found in assertion", driver.findElement(DocumentoOwner).getText().contains("Sergio Perales Vidal"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "The field Sergio Perales Vidal has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "The field AssertDocPalavra has been found on assertions", "INFO", level, 0, driver);
            finder3Page.setDocumentoPorTema("drive");
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "Typed " + "drive" + " in DocumentoPorTema", "INFO", level, 0, driver);
            finder3Page.clickFinderDocTema();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "Clicked FinderDocTema", "INFO", level, 0, driver);
            documentosPage.clickClickDocumentos3();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "Clicked ClickDocumentos3", "INFO", level, 0, driver);
            Assert.assertTrue("Field DocuTema not found in assertion", driver.findElement(DocuTema).getText().contains("drive"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "The field drive has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field DocuName not found in assertion", driver.findElement(DocuName).getText().contains("presentation.docx"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "The field presentation.docx has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field DocuOwner not found in assertion", driver.findElement(DocuOwner).getText().contains("Sergio Perales Vidal"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "The field Sergio Perales Vidal has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "The field AssertDocTema has been found on assertions", "INFO", level, 0, driver);
            finder4Page.setDocumentoOwner("documentos de sergio perales vidal");
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "Typed " + "documentos de sergio perales vidal" + " in DocumentoOwner", "INFO", level, 0, driver);
            finder4Page.clickFinderDocOwner();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "Clicked FinderDocOwner", "INFO", level, 0, driver);
            documentosPage.clickClickDocumentos();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "Clicked ClickDocumentos", "INFO", level, 0, driver);
            Assert.assertTrue("Field DocumentoNome1 not found in assertion", driver.findElement(DocumentoNome1).getText().contains("presentation.docx"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "The field presentation.docx has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field DocumentoOwner1 not found in assertion", driver.findElement(DocumentoOwner1).getText().contains("Sergio Perales Vidal"));
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "The field Sergio Perales Vidal has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "The field AssertDocOwner has been found on assertions", "INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrSuSub01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrSuSub01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RDDFPrSuSub01"+ ":" + finalResult);
        Report.addResults("Knowler", "RDDFPrSuSub01", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "Result on RDDFPrSuSub01: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void RDDFPrPeOfi01() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RDDFPrPeOfi01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeOfi01", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeOfi01", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            englishAction.doEnglishAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeOfi01", "Action EnglishAction finished","INFO", level, 0, driver);
            finderPage.setProjectsJapon("Empleados  de la oficina de Espana que hayan participado en proyectos en Japon");
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeOfi01", "Typed " + "Empleados  de la oficina de Espana que hayan participado en proyectos en Japon" + " in ProjectsJapon", "INFO", level, 0, driver);
            finderPage.clickFinderEmpProjectsJapon();
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeOfi01", "Clicked FinderEmpProjectsJapon", "INFO", level, 0, driver);
            Assert.assertTrue("Field ListEmployeeProjectsJapon not found in assertion", driver.findElement(ListEmployeeProjectsJapon).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeOfi01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeOfi01", "The field AssertProjectsJapon has been found on assertions", "INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeOfi01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeOfi01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeOfi01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeOfi01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RDDFPrPeOfi01"+ ":" + finalResult);
        Report.addResults("Knowler", "RDDFPrPeOfi01", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RDDFPrPeOfi01", "Result on RDDFPrPeOfi01: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void RuiRDDFPrPeEmp01() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RuiRDDFPrPeEmp01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeEmp01", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeEmp01", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            englishAction.doEnglishAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeEmp01", "Action EnglishAction finished","INFO", level, 0, driver);
            changeSearchTypePage.clickChangeSearchType();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeEmp01", "Clicked ChangeSearchType", "INFO", level, 0, driver);
            searchMyOffice365Page.clickSearchMyOffice365();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeEmp01", "Clicked SearchMyOffice365", "INFO", level, 0, driver);
            finderEmployeePage.setEmployeeName3("Sergio Perales Vidal");
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeEmp01", "Typed " + "Sergio Perales Vidal" + " in EmployeeName3", "INFO", level, 5000, driver);
            finderEmployeePage.clickFinderEmployee3();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeEmp01", "Clicked FinderEmployee3", "INFO", level, 5000, driver);
            Thread.sleep(5000);
            Assert.assertTrue("Field EmailDate not found in assertion", driver.findElement(EmailDate).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeEmp01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field EmailsTab not found in assertion", driver.findElement(EmailsTab).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeEmp01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field EmailName not found in assertion", driver.findElement(EmailName).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeEmp01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeEmp01", "The field AssertEmailsTab has been found on assertions", "INFO", level, 0, driver);
            clickEmailPage.clickClickEmail1();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeEmp01", "Clicked ClickEmail1", "INFO", level, 3000, driver);
            Thread.sleep(3000);
            selectDocumentsTabPage.clickSelectDocumentsTab();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeEmp01", "Clicked SelectDocumentsTab", "INFO", level, 5000, driver);
            Thread.sleep(5000);
            Assert.assertTrue("Field DocumentsTab not found in assertion", driver.findElement(DocumentsTab).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeEmp01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field DocumentsEmpty not found in assertion", driver.findElement(DocumentsEmpty).getText().contains("No results found"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeEmp01", "The field No results found has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeEmp01", "The field AssertDocumentsTab has been found on assertions", "INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeEmp01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeEmp01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeEmp01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeEmp01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RuiRDDFPrPeEmp01"+ ":" + finalResult);
        Report.addResults("Knowler", "RuiRDDFPrPeEmp01", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeEmp01", "Result on RuiRDDFPrPeEmp01: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void RuiRDDFPrCaPer02() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RuiRDDFPrCaPer02";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrCaPer02", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrCaPer02", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            englishAction.doEnglishAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrCaPer02", "Action EnglishAction finished","INFO", level, 0, driver);
            finderEmployeePage.setPersonEmployeeName("Sergio Perales Vidal");
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrCaPer02", "Typed " + "Sergio Perales Vidal" + " in PersonEmployeeName", "INFO", level, 0, driver);
            finderEmployeePage.clickFinderPersonEmployee();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrCaPer02", "Clicked FinderPersonEmployee", "INFO", level, 0, driver);
            employeesTabPage.clickSelectEmployeesTab();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrCaPer02", "Clicked SelectEmployeesTab", "INFO", level, 0, driver);
            goToProfilePage.clickGoToProfile();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrCaPer02", "Clicked GoToProfile", "INFO", level, 0, driver);
            Assert.assertTrue("Field PersonArea not found in assertion", driver.findElement(PersonArea).getText().contains("Innovation"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrCaPer02", "The field Innovation has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field PersonLocation not found in assertion", driver.findElement(PersonLocation).getText().contains("Zaragoza"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrCaPer02", "The field Zaragoza has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field PersonContacts not found in assertion", driver.findElement(PersonContacts).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrCaPer02", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field PersonConnections not found in assertion", driver.findElement(PersonConnections).getText().contains("Connections"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrCaPer02", "The field Connections has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field PersonPhoto not found in assertion", driver.findElement(PersonPhoto).getAttribute("src") != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrCaPer02", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field PersonName not found in assertion", driver.findElement(PersonName).getText().contains("Sergio Perales Vidal"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrCaPer02", "The field Sergio Perales Vidal has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field PersonCategory not found in assertion", driver.findElement(PersonCategory).getText().contains("System Analyst"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrCaPer02", "The field System Analyst has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrCaPer02", "The field AssertPersonEmployeeCard has been found on assertions", "INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrCaPer02", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrCaPer02", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrCaPer02", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrCaPer02", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RuiRDDFPrCaPer02"+ ":" + finalResult);
        Report.addResults("Knowler", "RuiRDDFPrCaPer02", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrCaPer02", "Result on RuiRDDFPrCaPer02: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void RuiRDDFPrEnAss01() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RuiRDDFPrEnAss01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnAss01", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnAss01", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            englishAction.doEnglishAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnAss01", "Action EnglishAction finished","INFO", level, 0, driver);
            finderAssetPage.setAssetName("Implementation of Knowter");
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnAss01", "Typed " + "Implementation of Knowter" + " in AssetName", "INFO", level, 0, driver);
            finderAssetPage.clickFinderAsset();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnAss01", "Clicked FinderAsset", "INFO", level, 0, driver);
            Assert.assertTrue("Field AssetType not found in assertion", driver.findElement(AssetType).getText().contains("112"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnAss01", "The field 112 has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field GraphConnections not found in assertion", driver.findElement(GraphConnections).getText().contains("Related Products"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnAss01", "The field Related Products has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field AssetIcon not found in assertion", driver.findElement(AssetIcon).getAttribute("src").contains("assets/images/icons/search/product.svg"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnAss01", "The field assets/images/icons/search/product.svg has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ServiceName not found in assertion", driver.findElement(ServiceName).getText().contains("Implementation of Knowter"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnAss01", "The field Implementation of Knowter has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field CompanyProduct not found in assertion", driver.findElement(CompanyProduct).getText().contains("Vivamus sed tortor gravida, elementum tellus feugiat, blandit neque."));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnAss01", "The field Vivamus sed tortor gravida, elementum tellus feugiat, blandit neque. has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field CompanyService not found in assertion", driver.findElement(CompanyService).getText().contains("Go to profile"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnAss01", "The field Go to profile has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnAss01", "The field AssertAsset1 has been found on assertions", "INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnAss01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrEnAss01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnAss01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrEnAss01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RuiRDDFPrEnAss01"+ ":" + finalResult);
        Report.addResults("Knowler", "RuiRDDFPrEnAss01", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnAss01", "Result on RuiRDDFPrEnAss01: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void RuiRDDFPrPeTea01() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RuiRDDFPrPeTea01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeTea01", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeTea01", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            englishAction.doEnglishAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeTea01", "Action EnglishAction finished","INFO", level, 0, driver);
            finderEmployeePage.setEmployeeName4("Sergio Perales Vidal");
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeTea01", "Typed " + "Sergio Perales Vidal" + " in EmployeeName4", "INFO", level, 0, driver);
            finderEmployeePage.clickFinderEmployee4();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeTea01", "Clicked FinderEmployee4", "INFO", level, 0, driver);
            goToProfilePage.clickGoToProfile2();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeTea01", "Clicked GoToProfile2", "INFO", level, 3000, driver);
            Thread.sleep(3000);
            Assert.assertTrue("Field ProfileArea not found in assertion", driver.findElement(ProfileArea).getText().contains("Innovation"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeTea01", "The field Innovation has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ResponsibleName1 not found in assertion", driver.findElement(ResponsibleName1).getText().contains("Carlos Galvan Pellicer"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeTea01", "The field Carlos Galvan Pellicer has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeTea01", "The field AssertProfileEmployee has been found on assertions", "INFO", level, 3000, driver);
            Thread.sleep(3000);
            viewProfileResponsiblePage.clickViewProfileResponsible();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeTea01", "Clicked ViewProfileResponsible", "INFO", level, 3000, driver);
            Thread.sleep(3000);
            Assert.assertTrue("Field Contacts not found in assertion", driver.findElement(Contacts).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeTea01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field Category not found in assertion", driver.findElement(Category).getText().contains("Project Leader"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeTea01", "The field Project Leader has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field MainResponsible not found in assertion", driver.findElement(MainResponsible).getText().contains("Javier Fernandez Luis"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeTea01", "The field Javier Fernandez Luis has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeTea01", "The field AssertProfileResponsible has been found on assertions", "INFO", level, 3000, driver);
            Thread.sleep(3000);
            returnToSearchPage.clickReturnToSearch();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeTea01", "Clicked ReturnToSearch", "INFO", level, 3000, driver);
            Thread.sleep(3000);
            goToProfilePage.clickGoToProfile1();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeTea01", "Clicked GoToProfile1", "INFO", level, 3000, driver);
            Thread.sleep(3000);
            viewProfileColleaguePage.clickViewProfileColleague();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeTea01", "Clicked ViewProfileColleague", "INFO", level, 3000, driver);
            Thread.sleep(3000);
            Assert.assertTrue("Field ColleagueArea1 not found in assertion", driver.findElement(ColleagueArea1).getText().contains("Innovation"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeTea01", "The field Innovation has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeTea01", "The field AssertProfileColleague has been found on assertions", "INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeTea01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeTea01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeTea01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeTea01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RuiRDDFPrPeTea01"+ ":" + finalResult);
        Report.addResults("Knowler", "RuiRDDFPrPeTea01", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeTea01", "Result on RuiRDDFPrPeTea01: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void RuiRDDFPrPePro01() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RuiRDDFPrPePro01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPePro01", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPePro01", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            englishAction.doEnglishAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPePro01", "Action EnglishAction finished","INFO", level, 0, driver);
            finderProfileAction.doFinderProfileAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPePro01", "Action FinderProfileAction finished","INFO", level, 0, driver);
            goToProfilePage.clickGoToProfile3();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPePro01", "Clicked GoToProfile3", "INFO", level, 0, driver);
            Assert.assertTrue("Field ProfileProjectsInProgress not found in assertion", driver.findElement(ProfileProjectsInProgress).getText().contains("In progress"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPePro01", "The field In progress has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ProfileProject1 not found in assertion", driver.findElement(ProfileProject1).getText().contains("BS - Learning Development'19"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPePro01", "The field BS - Learning Development'19 has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ProfileProject2 not found in assertion", driver.findElement(ProfileProject2).getText().contains("BS - Learning Development'18"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPePro01", "The field BS - Learning Development'18 has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ProfileProject3 not found in assertion", driver.findElement(ProfileProject3).getText().contains("BC Digital Rules"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPePro01", "The field BC Digital Rules has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ProfileProjectsTitle not found in assertion", driver.findElement(ProfileProjectsTitle).getText().contains("Projects"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPePro01", "The field Projects has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPePro01", "The field AssertProjectsInProfile has been found on assertions", "INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPePro01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPePro01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPePro01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPePro01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RuiRDDFPrPePro01"+ ":" + finalResult);
        Report.addResults("Knowler", "RuiRDDFPrPePro01", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPePro01", "Result on RuiRDDFPrPePro01: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void RuiRDDFPrMiOrg05() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RuiRDDFPrMiOrg05";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiOrg05", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiOrg05", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            englishAction.doEnglishAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiOrg05", "Action EnglishAction finished","INFO", level, 0, driver);
            finderOrganizationPage.setOrganizationName("Bien'star Health");
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiOrg05", "Typed " + "Bien'star Health" + " in OrganizationName", "INFO", level, 0, driver);
            finderOrganizationPage.clickFinderOrganization();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiOrg05", "Clicked FinderOrganization", "INFO", level, 0, driver);
            goToProfilePage.clickGoToProfile4();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiOrg05", "Clicked GoToProfile4", "INFO", level, 0, driver);
            Assert.assertTrue("Field OrganizationName not found in assertion", driver.findElement(OrganizationName).getText().contains("Bien'star Health"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiOrg05", "The field Bien'star Health has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field Project2 not found in assertion", driver.findElement(Project2).getText().contains("BBNL Developmemnt"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiOrg05", "The field BBNL Developmemnt has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field Project3 not found in assertion", driver.findElement(Project3).getText().contains("U Health 17-19"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiOrg05", "The field U Health 17-19 has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field Project4 not found in assertion", driver.findElement(Project4).getText().contains("lsa Salud 17"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiOrg05", "The field lsa Salud 17 has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field Project5 not found in assertion", driver.findElement(Project5).getText().contains("BS - Learning Development'18"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiOrg05", "The field BS - Learning Development'18 has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field OrganizationIcon not found in assertion", driver.findElement(OrganizationIcon).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiOrg05", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field OrganizationCode not found in assertion", driver.findElement(OrganizationCode).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiOrg05", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field OrganizationSector not found in assertion", driver.findElement(OrganizationSector).getText().contains("Health"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiOrg05", "The field Health has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field OrganizationResponsible not found in assertion", driver.findElement(OrganizationResponsible).getText().contains("Not found responsible for this customer account"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiOrg05", "The field Not found responsible for this customer account has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field OrganizationProjectsInProgress not found in assertion", driver.findElement(OrganizationProjectsInProgress).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiOrg05", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field Project1 not found in assertion", driver.findElement(Project1).getText().contains("BC Digital Rules"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiOrg05", "The field BC Digital Rules has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiOrg05", "The field AssertOrganizationProfile has been found on assertions", "INFO", level, 0, driver);
            scrollDownPage.clickScrollDownPage();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiOrg05", "Clicked ScrollDownPage", "INFO", level, 0, driver);
            Assert.assertTrue("Field OrganizationStatus not found in assertion", driver.findElement(OrganizationStatus).getText().contains("Active account"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiOrg05", "The field Active account has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field OrganizationRelevantTags not found in assertion", driver.findElement(OrganizationRelevantTags).getText().contains("ETIQUETAS RELEVANTES"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiOrg05", "The field ETIQUETAS RELEVANTES has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiOrg05", "The field AssertBottomPage has been found on assertions", "INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiOrg05", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrMiOrg05", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiOrg05", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrMiOrg05", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RuiRDDFPrMiOrg05"+ ":" + finalResult);
        Report.addResults("Knowler", "RuiRDDFPrMiOrg05", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiOrg05", "Result on RuiRDDFPrMiOrg05: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void RuiRDDFPrFiVer01() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RuiRDDFPrFiVer01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            englishAction.doEnglishAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", "Action EnglishAction finished","INFO", level, 0, driver);
            finderSmartphonePage.setSmartphoneName("Smartphone");
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", "Typed " + "Smartphone" + " in SmartphoneName", "INFO", level, 0, driver);
            finderSmartphonePage.clickFinderSmartphone();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", "Clicked FinderSmartphone", "INFO", level, 0, driver);
            Assert.assertTrue("Field AllFilter1 not found in assertion", driver.findElement(AllFilter1).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", "The field AssertAllTab has been found on assertions", "INFO", level, 0, driver);
            selectEmployeesTabPage.clickSelectEmployeesTab1();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", "Clicked SelectEmployeesTab1", "INFO", level, 0, driver);
            Assert.assertTrue("Field EmployeesFilter not found in assertion", driver.findElement(EmployeesFilter).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", "The field AssertEmployeesTab has been found on assertions", "INFO", level, 0, driver);
            selectDocumentsTabPage.clickSelectDocumentsTab1();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", "Clicked SelectDocumentsTab1", "INFO", level, 0, driver);
            Assert.assertTrue("Field DocumentsFilter not found in assertion", driver.findElement(DocumentsFilter).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", "The field AssertDocumentsTab1 has been found on assertions", "INFO", level, 0, driver);
            selectClientsTabPage.clickSelectClientsTab();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", "Clicked SelectClientsTab", "INFO", level, 0, driver);
            Assert.assertTrue("Field ClientsFilter not found in assertion", driver.findElement(ClientsFilter).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", "The field AssertClientsTab has been found on assertions", "INFO", level, 0, driver);
            selectProjectsTabPage.clickSelectProjectsTab();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", "Clicked SelectProjectsTab", "INFO", level, 0, driver);
            Assert.assertTrue("Field ProjectsFilter1 not found in assertion", driver.findElement(ProjectsFilter1).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", "The field AssertProjectsTab has been found on assertions", "INFO", level, 0, driver);
            selectProductsTabPage.clickSelectProductsTab();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", "Clicked SelectProductsTab", "INFO", level, 0, driver);
            Assert.assertTrue("Field ProductsFilter1 not found in assertion", driver.findElement(ProductsFilter1).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", "The field AssertProductsTab has been found on assertions", "INFO", level, 0, driver);
            selectServicesTabPage.clickSelectServicesTab();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", "Clicked SelectServicesTab", "INFO", level, 0, driver);
            Assert.assertTrue("Field ServicesFilter1 not found in assertion", driver.findElement(ServicesFilter1).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", "The field AssertServicesTab has been found on assertions", "INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrFiVer01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrFiVer01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RuiRDDFPrFiVer01"+ ":" + finalResult);
        Report.addResults("Knowler", "RuiRDDFPrFiVer01", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", "Result on RuiRDDFPrFiVer01: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void RuiPSFUTKINDAT02() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RuiPSFUTKINDAT02";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiPSFUTKINDAT02", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiPSFUTKINDAT02", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            englishAction.doEnglishAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiPSFUTKINDAT02", "Action EnglishAction finished","INFO", level, 0, driver);
            finderDocFromUserPage.setUserDocumentName("Documents Sergio Perales Vidal");
            Report.reportLog(finalResult, folderTestCase, "RuiPSFUTKINDAT02", "Typed " + "Documents Sergio Perales Vidal" + " in UserDocumentName", "INFO", level, 0, driver);
            finderDocFromUserPage.clickFinderDocFromUser();
            Report.reportLog(finalResult, folderTestCase, "RuiPSFUTKINDAT02", "Clicked FinderDocFromUser", "INFO", level, 0, driver);
            selectDocumentsTabPage.clickSelectDocumentsTab2();
            Report.reportLog(finalResult, folderTestCase, "RuiPSFUTKINDAT02", "Clicked SelectDocumentsTab2", "INFO", level, 0, driver);
            Assert.assertTrue("Field DocumentDate not found in assertion", driver.findElement(DocumentDate).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiPSFUTKINDAT02", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field DocumentTitle not found in assertion", driver.findElement(DocumentTitle).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiPSFUTKINDAT02", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field DocumentUser not found in assertion", driver.findElement(DocumentUser).getText().contains("Sergio Perales Vidal"));
            Report.reportLog(finalResult, folderTestCase, "RuiPSFUTKINDAT02", "The field Sergio Perales Vidal has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiPSFUTKINDAT02", "The field AssertDocsTab has been found on assertions", "INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiPSFUTKINDAT02", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiPSFUTKINDAT02", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiPSFUTKINDAT02", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiPSFUTKINDAT02", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RuiPSFUTKINDAT02"+ ":" + finalResult);
        Report.addResults("Knowler", "RuiPSFUTKINDAT02", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RuiPSFUTKINDAT02", "Result on RuiPSFUTKINDAT02: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void RuiRDDFPrMiPer02() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RuiRDDFPrMiPer02";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            englishAction.doEnglishAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "Action EnglishAction finished","INFO", level, 0, driver);
            finderEmployeePage.setEmployeeName5("Sergio Perales Vidal");
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "Typed " + "Sergio Perales Vidal" + " in EmployeeName5", "INFO", level, 0, driver);
            finderEmployeePage.clickFinderEmployee5();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "Clicked FinderEmployee5", "INFO", level, 0, driver);
            goToProfilePage.clickGoToProfile5();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "Clicked GoToProfile5", "INFO", level, 3000, driver);
            Thread.sleep(3000);
            Assert.assertTrue("Field EmployeeTeams not found in assertion", driver.findElement(EmployeeTeams).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field EmployeeWorkExperience not found in assertion", driver.findElement(EmployeeWorkExperience).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field EmployeePhoto not found in assertion", driver.findElement(EmployeePhoto).getAttribute("src") != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field EmployeeSkills not found in assertion", driver.findElement(EmployeeSkills).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field EmployeeRecentProjects not found in assertion", driver.findElement(EmployeeRecentProjects).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field RecentProjectName not found in assertion", driver.findElement(RecentProjectName).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field RecentProjectClient not found in assertion", driver.findElement(RecentProjectClient).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field EmployeeFullName not found in assertion", driver.findElement(EmployeeFullName).getText().contains("Sergio Perales Vidal"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "The field Sergio Perales Vidal has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field EmployeeCategory not found in assertion", driver.findElement(EmployeeCategory).getText().contains("System Analyst"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "The field System Analyst has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field EmployeeArea not found in assertion", driver.findElement(EmployeeArea).getText().contains("Innovation"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "The field Innovation has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field EmployeeLocation not found in assertion", driver.findElement(EmployeeLocation).getText().contains("Zaragoza"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "The field Zaragoza has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field EmployeeEmail not found in assertion", driver.findElement(EmployeeEmail).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field EmployeeSkype not found in assertion", driver.findElement(EmployeeSkype).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field EmployeeConnectionsGraph not found in assertion", driver.findElement(EmployeeConnectionsGraph).getText().contains("Connections"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "The field Connections has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "The field AssertProfile has been found on assertions", "INFO", level, 0, driver);
            viewProfileResponsiblePage.clickViewProfileResponsible1();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "Clicked ViewProfileResponsible1", "INFO", level, 3000, driver);
            Thread.sleep(3000);
            Assert.assertTrue("Field ResponsibleFullName not found in assertion", driver.findElement(ResponsibleFullName).getText().contains("Carlos Galvan Pellicer"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "The field Carlos Galvan Pellicer has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ResponsibleManager not found in assertion", driver.findElement(ResponsibleManager).getText().contains("Javier Fernandez Luis"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "The field Javier Fernandez Luis has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ResponsibleCategory not found in assertion", driver.findElement(ResponsibleCategory).getText().contains("Project Leader"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "The field Project Leader has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ResponsibleConnections not found in assertion", driver.findElement(ResponsibleConnections).getText().contains("Connections"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "The field Connections has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "The field AssertProfileResponsible1 has been found on assertions", "INFO", level, 0, driver);
            backToEmployeeProfilePage.clickBackToEmployeeProfile();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "Clicked BackToEmployeeProfile", "INFO", level, 0, driver);
            Assert.assertTrue("Field Colleague1Category not found in assertion", driver.findElement(Colleague1Category).getText().contains("Software Developer"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "The field Software Developer has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field Colleague3Category not found in assertion", driver.findElement(Colleague3Category).getText().contains("Partner"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "The field Partner has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field Colleague1Connections not found in assertion", driver.findElement(Colleague1Connections).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field Colleague2Connections not found in assertion", driver.findElement(Colleague2Connections).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field Colleague3Connections not found in assertion", driver.findElement(Colleague3Connections).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field Colleague1FullName not found in assertion", driver.findElement(Colleague1FullName).getText().contains("Silvia Grande Manzanaro"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "The field Silvia Grande Manzanaro has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field Colleague2FullName not found in assertion", driver.findElement(Colleague2FullName).getText().contains("Cristian Benito Magallon"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "The field Cristian Benito Magallon has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field Colleague3FullName not found in assertion", driver.findElement(Colleague3FullName).getText().contains("Javier Fernandez Luis"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "The field Javier Fernandez Luis has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field Colleague2Category not found in assertion", driver.findElement(Colleague2Category).getText().contains("Software Developer"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "The field Software Developer has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "The field AssertColleagues has been found on assertions", "INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrMiPer02", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrMiPer02", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RuiRDDFPrMiPer02"+ ":" + finalResult);
        Report.addResults("Knowler", "RuiRDDFPrMiPer02", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "Result on RuiRDDFPrMiPer02: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void RuiRDDFPrPeCat05MD() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RuiRDDFPrPeCat05MD";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCat05MD", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCat05MD", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            englishAction.doEnglishAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCat05MD", "Action EnglishAction finished","INFO", level, 0, driver);
            finderDirectorZaragozaPage.setDirectorOfficeZaragoza("Director Oficina Zaragoza");
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCat05MD", "Typed " + "Director Oficina Zaragoza" + " in DirectorOfficeZaragoza", "INFO", level, 0, driver);
            finderDirectorZaragozaPage.clickFinderDirectorZaragoza();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCat05MD", "Clicked FinderDirectorZaragoza", "INFO", level, 0, driver);
            Assert.assertTrue("Field DirectorName not found in assertion", driver.findElement(DirectorName).getText().contains("Director"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCat05MD", "The field Director has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field DirectorLocation not found in assertion", driver.findElement(DirectorLocation).getText().contains("Zaragoza, Spain"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCat05MD", "The field Zaragoza, Spain has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field FeaturedResult not found in assertion", driver.findElement(FeaturedResult).getText().contains("Featured"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCat05MD", "The field Featured has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field DirectorResult not found in assertion", driver.findElement(DirectorResult).getText().contains("Director Oficina Zaragoza"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCat05MD", "The field Director Oficina Zaragoza has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCat05MD", "The field AssertDirectorZaragoza has been found on assertions", "INFO", level, 0, driver);
            finderManagerZaragozaPage.setManagerZaragoza("Manager Zaragoza");
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCat05MD", "Typed " + "Manager Zaragoza" + " in ManagerZaragoza", "INFO", level, 0, driver);
            finderManagerZaragozaPage.clickFinderManagerZaragoza1();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCat05MD", "Clicked FinderManagerZaragoza1", "INFO", level, 0, driver);
            Assert.assertTrue("Field FeaturedResult1 not found in assertion", driver.findElement(FeaturedResult1).getText().contains("Featured"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCat05MD", "The field Featured has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ManagerLocation not found in assertion", driver.findElement(ManagerLocation).getText().contains("Zaragoza, Spain"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCat05MD", "The field Zaragoza, Spain has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ManagerResult not found in assertion", driver.findElement(ManagerResult).getText().contains("Manager Zaragoza"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCat05MD", "The field Manager Zaragoza has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ManagerName not found in assertion", driver.findElement(ManagerName).getText().contains("Manager"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCat05MD", "The field Manager has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCat05MD", "The field AssertManagerZaragoza1 has been found on assertions", "INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCat05MD", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeCat05MD", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCat05MD", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeCat05MD", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RuiRDDFPrPeCat05MD"+ ":" + finalResult);
        Report.addResults("Knowler", "RuiRDDFPrPeCat05MD", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCat05MD", "Result on RuiRDDFPrPeCat05MD: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void RuiRDDFPrEnPro01() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RuiRDDFPrEnPro01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnPro01", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnPro01", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            englishAction.doEnglishAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnPro01", "Action EnglishAction finished","INFO", level, 0, driver);
            finderProductPage.setProductName("Knowtech SmartPhone 450");
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnPro01", "Typed " + "Knowtech SmartPhone 450" + " in ProductName", "INFO", level, 0, driver);
            finderProductPage.clickFinderProduct();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnPro01", "Clicked FinderProduct", "INFO", level, 0, driver);
            Assert.assertTrue("Field ProductCategory not found in assertion", driver.findElement(ProductCategory).getText().contains("1"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnPro01", "The field 1 has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ProductLine not found in assertion", driver.findElement(ProductLine).getText().contains("Smartphone"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnPro01", "The field Smartphone has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field CompanyAsset not found in assertion", driver.findElement(CompanyAsset).getText().contains("Phasellus ante leo, euismod id facilisis nec, efficitur et eros. Suspendisse justo sem, vehicula eget laoreet a, finibus eu elit. Donec mattis cursus efficitu"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnPro01", "The field Phasellus ante leo, euismod id facilisis nec, efficitur et eros. Suspendisse justo sem, vehicula eget laoreet a, finibus eu elit. Donec mattis cursus efficitu has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field GraphConnections1 not found in assertion", driver.findElement(GraphConnections1).getText().contains("Go to profile"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnPro01", "The field Go to profile has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ProductIcon not found in assertion", driver.findElement(ProductIcon).getAttribute("src").contains("assets/images/icons/search/product.svg"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnPro01", "The field assets/images/icons/search/product.svg has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ProductName not found in assertion", driver.findElement(ProductName).getText().contains("Knowtech SmartPhone 450"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnPro01", "The field Knowtech SmartPhone 450 has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnPro01", "The field AssertProduct has been found on assertions", "INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnPro01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrEnPro01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnPro01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrEnPro01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RuiRDDFPrEnPro01"+ ":" + finalResult);
        Report.addResults("Knowler", "RuiRDDFPrEnPro01", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnPro01", "Result on RuiRDDFPrEnPro01: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void RuiRDDFPrPeInf01() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RuiRDDFPrPeInf01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeInf01", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeInf01", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            englishAction.doEnglishAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeInf01", "Action EnglishAction finished","INFO", level, 0, driver);
            finderEmployeePage.setEmployeeName6("Sergio Perales Vidal");
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeInf01", "Typed " + "Sergio Perales Vidal" + " in EmployeeName6", "INFO", level, 0, driver);
            finderEmployeePage.clickFinderEmployee6();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeInf01", "Clicked FinderEmployee6", "INFO", level, 0, driver);
            Assert.assertTrue("Field EmployeeLocation1 not found in assertion", driver.findElement(EmployeeLocation1).getText().contains("Zaragoza, Spain"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeInf01", "The field Zaragoza, Spain has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field EmployeeNumber not found in assertion", driver.findElement(EmployeeNumber).getText().contains("640630330"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeInf01", "The field 640630330 has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field EmployeeType not found in assertion", driver.findElement(EmployeeType).getText().contains("Employee"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeInf01", "The field Employee has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field EmployeeCategory1 not found in assertion", driver.findElement(EmployeeCategory1).getText().contains("System Analyst"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeInf01", "The field System Analyst has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field EmployeeWidgetName not found in assertion", driver.findElement(EmployeeWidgetName).getText().contains("Sergio Perales Vidal"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeInf01", "The field Sergio Perales Vidal has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeInf01", "The field AssertEmployeeWidget has been found on assertions", "INFO", level, 0, driver);
            goToProfilePage.clickGoToProfile6();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeInf01", "Clicked GoToProfile6", "INFO", level, 0, driver);
            Assert.assertTrue("Field EmployeeArea1 not found in assertion", driver.findElement(EmployeeArea1).getText().contains("Innovation"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeInf01", "The field Innovation has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field EmployeeProfileName not found in assertion", driver.findElement(EmployeeProfileName).getText().contains("Sergio Perales Vidal"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeInf01", "The field Sergio Perales Vidal has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeInf01", "The field AssertEmployeeProfile has been found on assertions", "INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeInf01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeInf01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeInf01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeInf01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RuiRDDFPrPeInf01"+ ":" + finalResult);
        Report.addResults("Knowler", "RuiRDDFPrPeInf01", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeInf01", "Result on RuiRDDFPrPeInf01: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void RuiRDDFPrAsInf01() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RuiRDDFPrAsInf01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrAsInf01", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrAsInf01", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            englishAction.doEnglishAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrAsInf01", "Action EnglishAction finished","INFO", level, 0, driver);
            finderWidgetPage.setWidgetName("Knowter");
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrAsInf01", "Typed " + "Knowter" + " in WidgetName", "INFO", level, 0, driver);
            finderWidgetPage.clickFinderWidget();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrAsInf01", "Clicked FinderWidget", "INFO", level, 0, driver);
            Assert.assertTrue("Field AssetCategory not found in assertion", driver.findElement(AssetCategory).getText().contains("General"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrAsInf01", "The field General has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field AssetResponsibleArea not found in assertion", driver.findElement(AssetResponsibleArea).getText().contains("Knowter is a knowledge management tool made for improving business proficiency"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrAsInf01", "The field Knowter is a knowledge management tool made for improving business proficiency has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ProductOrAssetCompany not found in assertion", driver.findElement(ProductOrAssetCompany).getText().contains("Asset"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrAsInf01", "The field Asset has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field Url not found in assertion", driver.findElement(Url).getText().contains("Go to profile"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrAsInf01", "The field Go to profile has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field AssetName not found in assertion", driver.findElement(AssetName).getText().contains("Knowter"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrAsInf01", "The field Knowter has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field Code not found in assertion", driver.findElement(Code).getText().contains("A001"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrAsInf01", "The field A001 has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field Type not found in assertion", driver.findElement(Type).getText().contains("Knowledge Management"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrAsInf01", "The field Knowledge Management has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrAsInf01", "The field AssertWidget1 has been found on assertions", "INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrAsInf01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrAsInf01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrAsInf01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrAsInf01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RuiRDDFPrAsInf01"+ ":" + finalResult);
        Report.addResults("Knowler", "RuiRDDFPrAsInf01", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrAsInf01", "Result on RuiRDDFPrAsInf01: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void RuiKORDDFPrPeSki01() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RuiKORDDFPrPeSki01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeSki01", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeSki01", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            englishAction.doEnglishAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeSki01", "Action EnglishAction finished","INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeSki01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiKORDDFPrPeSki01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeSki01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiKORDDFPrPeSki01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RuiKORDDFPrPeSki01"+ ":" + finalResult);
        Report.addResults("Knowler", "RuiKORDDFPrPeSki01", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeSki01", "Result on RuiKORDDFPrPeSki01: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void RuiKORDDFPrPeRes01() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RuiKORDDFPrPeRes01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeRes01", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeRes01", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            englishAction.doEnglishAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeRes01", "Action EnglishAction finished","INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeRes01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiKORDDFPrPeRes01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeRes01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiKORDDFPrPeRes01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RuiKORDDFPrPeRes01"+ ":" + finalResult);
        Report.addResults("Knowler", "RuiKORDDFPrPeRes01", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeRes01", "Result on RuiKORDDFPrPeRes01: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void RuiRDDFPrPeCon03() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RuiRDDFPrPeCon03";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCon03", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCon03", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            englishAction.doEnglishAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCon03", "Action EnglishAction finished","INFO", level, 0, driver);
            finderProfileAction.doFinderProfileAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCon03", "Action FinderProfileAction finished","INFO", level, 0, driver);
            goToProfilePage.clickGoToProfile7();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCon03", "Clicked GoToProfile7", "INFO", level, 0, driver);
            Assert.assertTrue("Field EmployeeName not found in assertion", driver.findElement(EmployeeName).getText().contains("Sergio Perales Vidal"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCon03", "The field Sergio Perales Vidal has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field EmployeeContacts not found in assertion", driver.findElement(EmployeeContacts).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCon03", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field EmployeeCategory2 not found in assertion", driver.findElement(EmployeeCategory2).getText().contains("System Analyst"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCon03", "The field System Analyst has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field EmployeeArea2 not found in assertion", driver.findElement(EmployeeArea2).getText().contains("Innovation"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCon03", "The field Innovation has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCon03", "The field AssertProfile1 has been found on assertions", "INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCon03", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeCon03", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCon03", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeCon03", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RuiRDDFPrPeCon03"+ ":" + finalResult);
        Report.addResults("Knowler", "RuiRDDFPrPeCon03", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCon03", "Result on RuiRDDFPrPeCon03: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void RuiRDDFPrPeCol01() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RuiRDDFPrPeCol01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            englishAction.doEnglishAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "Action EnglishAction finished","INFO", level, 0, driver);
            finderEmployeePage.setEmployeeName7("Sergio Perales Vidal");
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "Typed " + "Sergio Perales Vidal" + " in EmployeeName7", "INFO", level, 5000, driver);
            finderEmployeePage.clickFinderEmployee7();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "Clicked FinderEmployee7", "INFO", level, 5000, driver);
            Thread.sleep(5000);
            Assert.assertTrue("Field EmployeeName4 not found in assertion", driver.findElement(EmployeeName4).getText().contains("Sergio Perales Vidal"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "The field Sergio Perales Vidal has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field FeaturedTitle not found in assertion", driver.findElement(FeaturedTitle).getText().contains("Featured"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "The field Featured has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "The field AssertAllTab1 has been found on assertions", "INFO", level, 0, driver);
            moveToAssetProjectsPage.clickMoveToAssetProjects();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "Clicked MoveToAssetProjects", "INFO", level, 5000, driver);
            Thread.sleep(5000);
            Assert.assertTrue("Field ProjectsTitle not found in assertion", driver.findElement(ProjectsTitle).getText().contains("Projects"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "The field Projects has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field Project11 not found in assertion", driver.findElement(Project11).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "The field AssertAssetProjects has been found on assertions", "INFO", level, 0, driver);
            selectProjectsTabPage.clickSelectProjectsTab1();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "Clicked SelectProjectsTab1", "INFO", level, 0, driver);
            Assert.assertTrue("Field ProjectsResults not found in assertion", driver.findElement(ProjectsResults).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ProjectName not found in assertion", driver.findElement(ProjectName).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ProjectArea not found in assertion", driver.findElement(ProjectArea).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ProjectStartDate not found in assertion", driver.findElement(ProjectStartDate).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "The field AssertProjectsTab1 has been found on assertions", "INFO", level, 0, driver);
            selectFirstProjectPage.clickSelectFirstProject();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "Clicked SelectFirstProject", "INFO", level, 0, driver);
            Assert.assertTrue("Field EmployeeName1 not found in assertion", driver.findElement(EmployeeName1).getText().contains("Sergio Perales Vidal"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "The field Sergio Perales Vidal has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ProjectName1 not found in assertion", driver.findElement(ProjectName1).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "The field AssertFirstProject has been found on assertions", "INFO", level, 0, driver);
            selectSecondProjectPage.clickSelectSecondProject();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "Clicked SelectSecondProject", "INFO", level, 0, driver);
            Assert.assertTrue("Field ProjectName2 not found in assertion", driver.findElement(ProjectName2).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field EmployeeName2 not found in assertion", driver.findElement(EmployeeName2).getText().contains("Sergio Perales Vidal"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "The field Sergio Perales Vidal has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "The field AssertSecondProject has been found on assertions", "INFO", level, 0, driver);
            selectThirdProjectPage.clickSelectThirdProject();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "Clicked SelectThirdProject", "INFO", level, 0, driver);
            Assert.assertTrue("Field ProjectName3 not found in assertion", driver.findElement(ProjectName3).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field EmployeeName3 not found in assertion", driver.findElement(EmployeeName3).getText().contains("Sergio Perales Vidal"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "The field Sergio Perales Vidal has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "The field AssertThirdProject has been found on assertions", "INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeCol01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeCol01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RuiRDDFPrPeCol01"+ ":" + finalResult);
        Report.addResults("Knowler", "RuiRDDFPrPeCol01", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "Result on RuiRDDFPrPeCol01: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void RuiKORDDFPrPeEdu01() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RuiKORDDFPrPeEdu01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeEdu01", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeEdu01", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            englishAction.doEnglishAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeEdu01", "Action EnglishAction finished","INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeEdu01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiKORDDFPrPeEdu01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeEdu01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiKORDDFPrPeEdu01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RuiKORDDFPrPeEdu01"+ ":" + finalResult);
        Report.addResults("Knowler", "RuiKORDDFPrPeEdu01", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeEdu01", "Result on RuiKORDDFPrPeEdu01: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void RuiRDDFPrPeOfi01() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RuiRDDFPrPeOfi01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeOfi01", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeOfi01", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            englishAction.doEnglishAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeOfi01", "Action EnglishAction finished","INFO", level, 0, driver);
            finderEmployeeProjectsPage.setEmployeesInJaponProjects("Empleados oficina España proyectos Japón");
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeOfi01", "Typed " + "Empleados oficina España proyectos Japón" + " in EmployeesInJaponProjects", "INFO", level, 0, driver);
            finderEmployeeProjectsPage.clickFinderEmployeeProjects();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeOfi01", "Clicked FinderEmployeeProjects", "INFO", level, 0, driver);
            Assert.assertTrue("Field AllTitle not found in assertion", driver.findElement(AllTitle).getText().contains("All"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeOfi01", "The field All has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field Employee1Name not found in assertion", driver.findElement(Employee1Name).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeOfi01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field Employee2Name not found in assertion", driver.findElement(Employee2Name).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeOfi01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field Employee3Name not found in assertion", driver.findElement(Employee3Name).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeOfi01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field ResultsTitle not found in assertion", driver.findElement(ResultsTitle).getText() != null);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeOfi01", "The field empty has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeOfi01", "The field AssertEmployeeProjects has been found on assertions", "INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeOfi01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeOfi01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeOfi01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeOfi01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RuiRDDFPrPeOfi01"+ ":" + finalResult);
        Report.addResults("Knowler", "RuiRDDFPrPeOfi01", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeOfi01", "Result on RuiRDDFPrPeOfi01: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }

    private void RuiRDDFPrSuSub01() throws Exception {
        String finalResult = "OK";
        ArrayList<String> results = new ArrayList<String>();
        String caseName = "RuiRDDFPrSuSub01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        folderTestCase.mkdirs();
        folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
        folderDownloads.mkdirs();
        String fileLocation = "";

        
        driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", contextsDriver);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "Start of Test execution", "INFO", level, 0, driver);
            knowlerLogInAction.doKnowlerLogInAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "Action KnowlerLogInAction finished","INFO", level, 0, driver);
            englishAction.doEnglishAction(folderDownloads, contextsDriver, finalResult,  folderTestCase, caseName, handler);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "Action EnglishAction finished","INFO", level, 0, driver);
            finderDocByNamePage.setDocName("helder_onedrive.docx");
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "Typed " + "helder_onedrive.docx" + " in DocName", "INFO", level, 0, driver);
            finderDocByNamePage.clickFinderDocByName();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "Clicked FinderDocByName", "INFO", level, 0, driver);
            documentsTabPage.clickDocumentsTab();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "Clicked DocumentsTab", "INFO", level, 0, driver);
            Assert.assertTrue("Field DocumentName not found in assertion", driver.findElement(DocumentName).getText().contains("helder_onedrive.docx"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "The field helder_onedrive.docx has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field OwnerName not found in assertion", driver.findElement(OwnerName).getText().contains("Sergio Perales Vidal"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "The field Sergio Perales Vidal has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "The field AssertDocByName has been found on assertions", "INFO", level, 0, driver);
            finderDocByWordPage.setDocByWord("Helder");
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "Typed " + "Helder" + " in DocByWord", "INFO", level, 0, driver);
            finderDocByWordPage.clickFinderDocByWord();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "Clicked FinderDocByWord", "INFO", level, 0, driver);
            documentsTabPage.clickDocumentsTab1();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "Clicked DocumentsTab1", "INFO", level, 0, driver);
            Assert.assertTrue("Field DocumentName1 not found in assertion", driver.findElement(DocumentName1).getText().contains("helder_onedrive.docx"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "The field helder_onedrive.docx has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field DocumentOwner not found in assertion", driver.findElement(DocumentOwner).getText().contains("Sergio Perales Vidal"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "The field Sergio Perales Vidal has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field DocumentWord not found in assertion", driver.findElement(DocumentWord).getText().contains("Helder"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "The field Helder has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "The field AssertDocByWord has been found on assertions", "INFO", level, 0, driver);
            findDocByThemePage.setDocByTheme("drive");
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "Typed " + "drive" + " in DocByTheme", "INFO", level, 0, driver);
            findDocByThemePage.clickFindDocByTheme();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "Clicked FindDocByTheme", "INFO", level, 0, driver);
            documentsTabPage.clickDocumentsTab2();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "Clicked DocumentsTab2", "INFO", level, 0, driver);
            Assert.assertTrue("Field DocumentTheme not found in assertion", driver.findElement(DocumentTheme).getText().contains("drives"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "The field drives has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field DocumentName2 not found in assertion", driver.findElement(DocumentName2).getText().contains("SKMO_Arquitectura_OneDrive.docx"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "The field SKMO_Arquitectura_OneDrive.docx has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field DocumentOwner1 not found in assertion", driver.findElement(DocumentOwner1).getText().contains("Sergio Perales Vidal"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "The field Sergio Perales Vidal has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "The field AssertDocByTheme has been found on assertions", "INFO", level, 0, driver);
            findDocByOwnerPage.setDocByOwner("Sergio Perales Vidal");
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "Typed " + "Sergio Perales Vidal" + " in DocByOwner", "INFO", level, 0, driver);
            findDocByOwnerPage.clickFindDocByOwner();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "Clicked FindDocByOwner", "INFO", level, 0, driver);
            documentsTabPage.clickDocumentsTab3();
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "Clicked DocumentsTab3", "INFO", level, 0, driver);
            Assert.assertTrue("Field DocumentName3 not found in assertion", driver.findElement(DocumentName3).getText().contains("curso-ejemplos.pptx"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "The field curso-ejemplos.pptx has been found on assertion", "INFO", level, 0, driver);
            Assert.assertTrue("Field DocumentOwner2 not found in assertion", driver.findElement(DocumentOwner2).getText().contains("Sergio Perales Vidal"));
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "The field Sergio Perales Vidal has been found on assertion", "INFO", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "The field AssertDocByOwner has been found on assertions", "INFO", level, 1000, driver);
            Thread.sleep(1000);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrSuSub01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrSuSub01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
                
        results.add(0, finalResult);
        logger.info("Result on RuiRDDFPrSuSub01"+ ":" + finalResult);
        Report.addResults("Knowler", "RuiRDDFPrSuSub01", results.toArray(new String[results.size()]));
        Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "Result on RuiRDDFPrSuSub01: " + finalResult, "INFO", level, 0, driver);
        
        
        
        for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
                context.getValue().quit();
        }
        contextsDriver.clear();
    }
    private boolean RDDFPrPeEmp01Before() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RDDFPrPeEmp01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeEmp01", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeEmp01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeEmp01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeEmp01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeEmp01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RDDFPrPeEmp01", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean RDDFPrPeTea01Before() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RDDFPrPeTea01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeTea01", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeTea01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeTea01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeTea01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeTea01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RDDFPrPeTea01", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean RDDFPrEnAss01Before() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RDDFPrEnAss01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnAss01", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnAss01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrEnAss01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnAss01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrEnAss01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RDDFPrEnAss01", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean RDDFPrFiVer01Before() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RDDFPrFiVer01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrFiVer01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrFiVer01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RDDFPrFiVer01", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean RDDFPrMiPer02Before() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RDDFPrMiPer02";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrMiPer02", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrMiPer02", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrMiPer02", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrMiPer02", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrMiPer02", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RDDFPrMiPer02", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean PSFUTKINDAT02Before() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "PSFUTKINDAT02";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "PSFUTKINDAT02", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "PSFUTKINDAT02", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"PSFUTKINDAT02", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "PSFUTKINDAT02", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"PSFUTKINDAT02", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "PSFUTKINDAT02", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean RDDFPrEnPro01Before() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RDDFPrEnPro01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnPro01", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnPro01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrEnPro01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnPro01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrEnPro01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RDDFPrEnPro01", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean RDDFPrPeCon03Before() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RDDFPrPeCon03";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCon03", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCon03", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeCon03", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCon03", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeCon03", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RDDFPrPeCon03", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean KnowlerPageBefore() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "KnowlerPage";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "KnowlerPage", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "KnowlerPage", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"KnowlerPage", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "KnowlerPage", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"KnowlerPage", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "KnowlerPage", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean RDDFPrPeCat05MDBefore() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RDDFPrPeCat05MD";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCat05MD", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCat05MD", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeCat05MD", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCat05MD", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeCat05MD", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RDDFPrPeCat05MD", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean RDDFPrAsInf01Before() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RDDFPrAsInf01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrAsInf01", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrAsInf01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrAsInf01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrAsInf01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrAsInf01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RDDFPrAsInf01", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean RDDFPrPeCol01Before() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RDDFPrPeCol01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCol01", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCol01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeCol01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCol01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeCol01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RDDFPrPeCol01", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean RDDFPrSuSub01Before() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RDDFPrSuSub01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrSuSub01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrSuSub01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RDDFPrSuSub01", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean RDDFPrPeOfi01Before() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RDDFPrPeOfi01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeOfi01", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeOfi01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeOfi01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeOfi01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeOfi01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RDDFPrPeOfi01", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean RuiRDDFPrPeEmp01Before() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RuiRDDFPrPeEmp01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeEmp01", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeEmp01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeEmp01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeEmp01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeEmp01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RuiRDDFPrPeEmp01", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean RuiRDDFPrCaPer02Before() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RuiRDDFPrCaPer02";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrCaPer02", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrCaPer02", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrCaPer02", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrCaPer02", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrCaPer02", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RuiRDDFPrCaPer02", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean RuiRDDFPrEnAss01Before() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RuiRDDFPrEnAss01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnAss01", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnAss01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrEnAss01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnAss01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrEnAss01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RuiRDDFPrEnAss01", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean RuiRDDFPrPeTea01Before() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RuiRDDFPrPeTea01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeTea01", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeTea01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeTea01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeTea01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeTea01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RuiRDDFPrPeTea01", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean RuiRDDFPrPePro01Before() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RuiRDDFPrPePro01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPePro01", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPePro01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPePro01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPePro01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPePro01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RuiRDDFPrPePro01", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean RuiRDDFPrMiOrg05Before() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RuiRDDFPrMiOrg05";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiOrg05", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiOrg05", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrMiOrg05", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiOrg05", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrMiOrg05", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RuiRDDFPrMiOrg05", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean RuiRDDFPrFiVer01Before() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RuiRDDFPrFiVer01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrFiVer01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrFiVer01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RuiRDDFPrFiVer01", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean RuiPSFUTKINDAT02Before() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RuiPSFUTKINDAT02";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiPSFUTKINDAT02", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiPSFUTKINDAT02", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiPSFUTKINDAT02", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiPSFUTKINDAT02", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiPSFUTKINDAT02", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RuiPSFUTKINDAT02", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean RuiRDDFPrMiPer02Before() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RuiRDDFPrMiPer02";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrMiPer02", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrMiPer02", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RuiRDDFPrMiPer02", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean RuiRDDFPrPeCat05MDBefore() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RuiRDDFPrPeCat05MD";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCat05MD", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCat05MD", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeCat05MD", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCat05MD", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeCat05MD", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RuiRDDFPrPeCat05MD", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean RuiRDDFPrEnPro01Before() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RuiRDDFPrEnPro01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnPro01", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnPro01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrEnPro01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnPro01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrEnPro01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RuiRDDFPrEnPro01", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean RuiRDDFPrPeInf01Before() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RuiRDDFPrPeInf01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeInf01", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeInf01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeInf01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeInf01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeInf01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RuiRDDFPrPeInf01", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean RuiRDDFPrAsInf01Before() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RuiRDDFPrAsInf01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrAsInf01", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrAsInf01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrAsInf01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrAsInf01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrAsInf01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RuiRDDFPrAsInf01", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean RuiKORDDFPrPeSki01Before() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RuiKORDDFPrPeSki01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeSki01", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeSki01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiKORDDFPrPeSki01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeSki01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiKORDDFPrPeSki01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RuiKORDDFPrPeSki01", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean RuiKORDDFPrPeRes01Before() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RuiKORDDFPrPeRes01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeRes01", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeRes01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiKORDDFPrPeRes01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeRes01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiKORDDFPrPeRes01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RuiKORDDFPrPeRes01", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean RuiRDDFPrPeCon03Before() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RuiRDDFPrPeCon03";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCon03", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCon03", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeCon03", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCon03", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeCon03", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RuiRDDFPrPeCon03", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean RuiRDDFPrPeCol01Before() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RuiRDDFPrPeCol01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeCol01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeCol01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RuiRDDFPrPeCol01", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean RuiKORDDFPrPeEdu01Before() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RuiKORDDFPrPeEdu01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeEdu01", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeEdu01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiKORDDFPrPeEdu01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeEdu01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiKORDDFPrPeEdu01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RuiKORDDFPrPeEdu01", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean RuiRDDFPrPeOfi01Before() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RuiRDDFPrPeOfi01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeOfi01", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeOfi01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeOfi01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeOfi01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeOfi01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RuiRDDFPrPeOfi01", results.toArray(new String[results.size()]));
        return bq;
    }

    private boolean RuiRDDFPrSuSub01Before() throws Exception {
        String finalResult = "OK";
        boolean bq = true;
        String caseName = "RuiRDDFPrSuSub01";
	    File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        ArrayList<String> results = new ArrayList<String>();
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "Start of Before execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrSuSub01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrSuSub01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            bq = false;
        }
        
        results.add(0, finalResult);
        Report.addResults("Knowler", "RuiRDDFPrSuSub01", results.toArray(new String[results.size()]));
        return bq;
    }
    
    private void RDDFPrPeEmp01After() throws Exception {
        String finalResult = "OK";
        String caseName = "RDDFPrPeEmp01";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeEmp01", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeEmp01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeEmp01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeEmp01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeEmp01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void RDDFPrPeTea01After() throws Exception {
        String finalResult = "OK";
        String caseName = "RDDFPrPeTea01";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeTea01", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeTea01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeTea01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeTea01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeTea01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void RDDFPrEnAss01After() throws Exception {
        String finalResult = "OK";
        String caseName = "RDDFPrEnAss01";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnAss01", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnAss01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrEnAss01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnAss01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrEnAss01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void RDDFPrFiVer01After() throws Exception {
        String finalResult = "OK";
        String caseName = "RDDFPrFiVer01";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrFiVer01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrFiVer01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrFiVer01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void RDDFPrMiPer02After() throws Exception {
        String finalResult = "OK";
        String caseName = "RDDFPrMiPer02";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrMiPer02", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrMiPer02", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrMiPer02", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrMiPer02", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrMiPer02", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void PSFUTKINDAT02After() throws Exception {
        String finalResult = "OK";
        String caseName = "PSFUTKINDAT02";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "PSFUTKINDAT02", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "PSFUTKINDAT02", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"PSFUTKINDAT02", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "PSFUTKINDAT02", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"PSFUTKINDAT02", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void RDDFPrEnPro01After() throws Exception {
        String finalResult = "OK";
        String caseName = "RDDFPrEnPro01";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnPro01", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnPro01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrEnPro01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrEnPro01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrEnPro01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void RDDFPrPeCon03After() throws Exception {
        String finalResult = "OK";
        String caseName = "RDDFPrPeCon03";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCon03", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCon03", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeCon03", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCon03", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeCon03", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void KnowlerPageAfter() throws Exception {
        String finalResult = "OK";
        String caseName = "KnowlerPage";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "KnowlerPage", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "KnowlerPage", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"KnowlerPage", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "KnowlerPage", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"KnowlerPage", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void RDDFPrPeCat05MDAfter() throws Exception {
        String finalResult = "OK";
        String caseName = "RDDFPrPeCat05MD";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCat05MD", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCat05MD", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeCat05MD", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCat05MD", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeCat05MD", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void RDDFPrAsInf01After() throws Exception {
        String finalResult = "OK";
        String caseName = "RDDFPrAsInf01";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrAsInf01", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrAsInf01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrAsInf01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrAsInf01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrAsInf01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void RDDFPrPeCol01After() throws Exception {
        String finalResult = "OK";
        String caseName = "RDDFPrPeCol01";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCol01", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCol01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeCol01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeCol01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeCol01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void RDDFPrSuSub01After() throws Exception {
        String finalResult = "OK";
        String caseName = "RDDFPrSuSub01";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrSuSub01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrSuSub01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrSuSub01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void RDDFPrPeOfi01After() throws Exception {
        String finalResult = "OK";
        String caseName = "RDDFPrPeOfi01";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeOfi01", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeOfi01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeOfi01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RDDFPrPeOfi01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RDDFPrPeOfi01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void RuiRDDFPrPeEmp01After() throws Exception {
        String finalResult = "OK";
        String caseName = "RuiRDDFPrPeEmp01";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeEmp01", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeEmp01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeEmp01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeEmp01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeEmp01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void RuiRDDFPrCaPer02After() throws Exception {
        String finalResult = "OK";
        String caseName = "RuiRDDFPrCaPer02";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrCaPer02", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrCaPer02", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrCaPer02", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrCaPer02", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrCaPer02", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void RuiRDDFPrEnAss01After() throws Exception {
        String finalResult = "OK";
        String caseName = "RuiRDDFPrEnAss01";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnAss01", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnAss01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrEnAss01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnAss01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrEnAss01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void RuiRDDFPrPeTea01After() throws Exception {
        String finalResult = "OK";
        String caseName = "RuiRDDFPrPeTea01";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeTea01", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeTea01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeTea01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeTea01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeTea01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void RuiRDDFPrPePro01After() throws Exception {
        String finalResult = "OK";
        String caseName = "RuiRDDFPrPePro01";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPePro01", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPePro01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPePro01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPePro01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPePro01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void RuiRDDFPrMiOrg05After() throws Exception {
        String finalResult = "OK";
        String caseName = "RuiRDDFPrMiOrg05";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiOrg05", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiOrg05", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrMiOrg05", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiOrg05", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrMiOrg05", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void RuiRDDFPrFiVer01After() throws Exception {
        String finalResult = "OK";
        String caseName = "RuiRDDFPrFiVer01";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrFiVer01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrFiVer01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrFiVer01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void RuiPSFUTKINDAT02After() throws Exception {
        String finalResult = "OK";
        String caseName = "RuiPSFUTKINDAT02";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiPSFUTKINDAT02", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiPSFUTKINDAT02", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiPSFUTKINDAT02", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiPSFUTKINDAT02", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiPSFUTKINDAT02", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void RuiRDDFPrMiPer02After() throws Exception {
        String finalResult = "OK";
        String caseName = "RuiRDDFPrMiPer02";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrMiPer02", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrMiPer02", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrMiPer02", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void RuiRDDFPrPeCat05MDAfter() throws Exception {
        String finalResult = "OK";
        String caseName = "RuiRDDFPrPeCat05MD";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCat05MD", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCat05MD", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeCat05MD", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCat05MD", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeCat05MD", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void RuiRDDFPrEnPro01After() throws Exception {
        String finalResult = "OK";
        String caseName = "RuiRDDFPrEnPro01";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnPro01", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnPro01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrEnPro01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrEnPro01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrEnPro01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void RuiRDDFPrPeInf01After() throws Exception {
        String finalResult = "OK";
        String caseName = "RuiRDDFPrPeInf01";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeInf01", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeInf01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeInf01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeInf01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeInf01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void RuiRDDFPrAsInf01After() throws Exception {
        String finalResult = "OK";
        String caseName = "RuiRDDFPrAsInf01";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrAsInf01", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrAsInf01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrAsInf01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrAsInf01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrAsInf01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void RuiKORDDFPrPeSki01After() throws Exception {
        String finalResult = "OK";
        String caseName = "RuiKORDDFPrPeSki01";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeSki01", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeSki01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiKORDDFPrPeSki01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeSki01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiKORDDFPrPeSki01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void RuiKORDDFPrPeRes01After() throws Exception {
        String finalResult = "OK";
        String caseName = "RuiKORDDFPrPeRes01";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeRes01", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeRes01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiKORDDFPrPeRes01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeRes01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiKORDDFPrPeRes01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void RuiRDDFPrPeCon03After() throws Exception {
        String finalResult = "OK";
        String caseName = "RuiRDDFPrPeCon03";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCon03", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCon03", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeCon03", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCon03", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeCon03", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void RuiRDDFPrPeCol01After() throws Exception {
        String finalResult = "OK";
        String caseName = "RuiRDDFPrPeCol01";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeCol01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeCol01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeCol01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void RuiKORDDFPrPeEdu01After() throws Exception {
        String finalResult = "OK";
        String caseName = "RuiKORDDFPrPeEdu01";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeEdu01", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeEdu01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiKORDDFPrPeEdu01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiKORDDFPrPeEdu01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiKORDDFPrPeEdu01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void RuiRDDFPrPeOfi01After() throws Exception {
        String finalResult = "OK";
        String caseName = "RuiRDDFPrPeOfi01";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeOfi01", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeOfi01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeOfi01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrPeOfi01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrPeOfi01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
        
    private void RuiRDDFPrSuSub01After() throws Exception {
        String finalResult = "OK";
        String caseName = "RuiRDDFPrSuSub01";
        File folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + caseName);
        
        try {
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", "Start of After execution", "INFO", level, 0, driver);
            

        } catch (AssertionError e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrSuSub01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        } catch (Exception e) {
            logger.severe(e.getMessage());
            finalResult = "KO";
            Report.reportLog(finalResult, folderTestCase, "RuiRDDFPrSuSub01", e.getMessage(), "ERROR", level, 0, driver);
            Report.reportLog(finalResult, folderTestCase,"RuiRDDFPrSuSub01", Throwables.getStackTraceAsString(e), "DEBUG", level, 0, driver);
            
        }
        
    }
}