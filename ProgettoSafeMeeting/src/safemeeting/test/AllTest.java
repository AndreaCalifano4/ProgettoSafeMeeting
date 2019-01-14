package safemeeting.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
    TestServletRegistraAccount.class, 
    TestServletLogin.class, TestServletLogout.class,
    TestServletRicerca.class, TestStudenteDao.class,
    TestPreferitiDao.class, TestDocenteDao.class,
    TestRicevimentoDao.class, TestCorsoDao.class, 
    TestPrenotaDao.class, TestServletStampaCorsi.class,
    TestServletStampaPrenotazioni.class, TestServletStampaRicevimenti.class 
    })
public class AllTest {

}


