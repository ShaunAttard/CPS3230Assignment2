package um.cps3230.website;

import junit.framework.Assert;
import nz.ac.waikato.modeljunit.*;
import nz.ac.waikato.modeljunit.coverage.ActionCoverage;
import nz.ac.waikato.modeljunit.coverage.StateCoverage;
import nz.ac.waikato.modeljunit.coverage.TransitionPairCoverage;
import org.json.JSONObject;
import org.junit.Test;
import um.cps3230.WebsiteOperator;
import um.cps3230.enums.WebsiteStates;

import java.util.Random;

public class WebsiteModelTest implements FsmModel {
    private boolean login = true, viewAlerts = false, upload = false, delete = false, invalidAlert = false, checkLimit = false, invalidDelete = false, alertLimit = false;
    private WebsiteOperator sut = new WebsiteOperator();

    private WebsiteStates state = WebsiteStates.LOGIN;

    public WebsiteStates getState() {return state;}

    @Override
    public void reset(boolean b) {
        if (b){
            sut.CloseBrowser();
            sut = new WebsiteOperator();
        }
        state = WebsiteStates.LOGIN;
        login = true;
        viewAlerts = false;
        upload = false;
        delete = false;
        checkLimit = false;
        invalidAlert = false;
        invalidDelete = false;
        alertLimit = false;

        sut.getEventLog();
    }

    public boolean LoginGuard() {return getState().equals(WebsiteStates.LOGIN) || getState().equals(WebsiteStates.INVALIDALERT) || getState().equals(WebsiteStates.INVALIDDELETE) || getState().equals(WebsiteStates.ALERTLIMIT);}
    public @Action void Login() {
        boolean log = sut.Login();
        state = WebsiteStates.VIEWALERTS;
        viewAlerts = true;
        login = false;
        invalidAlert = false;
        invalidDelete = false;
        alertLimit = false;

        Assert.assertEquals(true, sut.isLoggedIn());
        Assert.assertEquals(viewAlerts, sut.isViewAlerts());
        Assert.assertEquals(login, sut.isLogin());

    }

    public boolean LoginInvalidGuard() {return getState().equals(WebsiteStates.LOGIN);}
    public @Action void LoginInvalid() {
        boolean log = sut.LoginInvalid();
        state = WebsiteStates.LOGIN;
        login = true;

        Assert.assertEquals(false, sut.isLoggedIn());
        Assert.assertEquals(login, sut.isLogin());
    }

    public boolean LogoutGuard() {return getState().equals(WebsiteStates.VIEWALERTS);}
    public @Action void Logout() {
        boolean log = sut.Logout();
        state = WebsiteStates.LOGIN;
        login = true;
        viewAlerts = false;

        Assert.assertEquals(false, sut.isLoggedIn());
        Assert.assertEquals(login, sut.isLogin());
        Assert.assertEquals(viewAlerts, sut.isViewAlerts());

    }

    public boolean UploadGuard() {return getState().equals(WebsiteStates.VIEWALERTS);}
    public @Action void Upload() {
        int code = sut.Upload();
        state = WebsiteStates.UPLOAD;
        upload = true;
        viewAlerts = false;

        Assert.assertEquals(201, code);
        Assert.assertEquals(upload, sut.isUpload());
        Assert.assertEquals(viewAlerts, sut.isViewAlerts());
    }

    public boolean InvalidUploadGuard() {return getState().equals(WebsiteStates.VIEWALERTS);}
    public @Action void InvalidUpload() {
        int code = sut.UploadInvalid();
        state = WebsiteStates.INVALIDALERT;
        invalidAlert = true;
        viewAlerts = false;

        Assert.assertNotSame(201, code);
        Assert.assertEquals(invalidAlert, sut.isInvalidAlert());
        Assert.assertEquals(viewAlerts, sut.isViewAlerts());
    }

    public boolean DeleteGuard() {return getState().equals(WebsiteStates.VIEWALERTS);}
    public @Action void Delete() {
        int code = sut.Delete();
        state = WebsiteStates.DELETE;
        delete = true;
        viewAlerts = false;

        Assert.assertEquals(200, code);
        Assert.assertEquals(delete, sut.isDelete());
        Assert.assertEquals(viewAlerts, sut.isViewAlerts());
    }

    public boolean InvalidDeleteGuard() {return getState().equals(WebsiteStates.VIEWALERTS);}
    public @Action void InvalidDelete() {
        int code = sut.DeleteInvalid();
        state = WebsiteStates.INVALIDDELETE;
        invalidDelete = true;
        viewAlerts = false;

        Assert.assertEquals(400, code);
        Assert.assertEquals(invalidDelete, sut.isInvalidDelete());
        Assert.assertEquals(viewAlerts, sut.isViewAlerts());
    }

    public boolean ViewAlertsGuard() {return getState().equals(WebsiteStates.CHECKLIMIT) || getState().equals(WebsiteStates.DELETE);}
    public @Action void ViewAlerts() {
        String url = sut.ViewAlerts();
        state = WebsiteStates.VIEWALERTS;
        sut.getEventLog();
        viewAlerts = true;
        checkLimit = false;
        delete = false;

        Assert.assertEquals("https://www.marketalertum.com/Alerts/List", url);
        Assert.assertEquals(viewAlerts, sut.isViewAlerts());
        Assert.assertEquals(checkLimit, sut.isCheckLimit());
        Assert.assertEquals(delete, sut.isDelete());
    }

    public boolean CheckLimitGuard() {return getState().equals(WebsiteStates.UPLOAD);}
    public @Action void CheckLimit() {
        boolean limit = sut.CheckLimit();
        state = WebsiteStates.CHECKLIMIT;
        checkLimit = true;
        upload = false;

        Assert.assertEquals(true, limit);
        Assert.assertEquals(checkLimit, sut.isCheckLimit());
        Assert.assertEquals(upload, sut.isUpload());
    }

    public boolean CheckLimitInvalidGuard() {return getState().equals(WebsiteStates.UPLOAD);}
    public @Action void CheckLimitInvalid() {
        boolean limit = sut.CheckLimitInvalid();
        state = WebsiteStates.ALERTLIMIT;
        alertLimit = true;
        upload = false;

        Assert.assertEquals(false, limit);
        Assert.assertEquals(alertLimit, sut.isAlertLimit());
        Assert.assertEquals(upload, sut.isUpload());
    }

    @Test
    public void WebsiteModelRunner(){
        sut.getEventLog();
        final GreedyTester tester = new GreedyTester(new WebsiteModelTest());
        tester.setRandom(new Random());
        tester.buildGraph();
        tester.addListener(new StopOnFailureListener());
        tester.addListener("verbose");
        tester.addCoverageMetric(new TransitionPairCoverage());
        tester.addCoverageMetric(new StateCoverage());
        tester.addCoverageMetric(new ActionCoverage());
        tester.generate(550);
        tester.printCoverage();
        sut.CloseBrowser();
    }
}
