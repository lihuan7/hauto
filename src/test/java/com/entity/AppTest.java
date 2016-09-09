package com.entity;

import com.service.HumanService;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

    private HumanService humanService = new HumanService();

    public void testApp() {
        humanService.beginTransaction();
        Human human = humanService.addHuman("Васильев", "Иван", "Петрович");
        Human human1 = humanService.addHuman("Пертров", "Иван", "Петрович");
        humanService.addAutoToHuman("Volkswagen", "Golf-6", human);
        humanService.addAutoToHuman("Lada", "Vesta", human);
        humanService.addAutoToHuman("Lada", "Niva", human1);
        humanService.endTransaction();
    }
}
