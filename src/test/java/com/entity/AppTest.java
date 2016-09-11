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

        City cityPerm = humanService.addCity("г. Пермь");

        Human human = humanService.addHuman("Иван", "Петрович", "Васильев",cityPerm);
        Human human1 = humanService.addHuman("Андрей", "Алексеевич", "Сидоров", cityPerm);
        Human human2 = humanService.addHuman("Роман", "Александрович", "Никулин", cityPerm);
        humanService.addAutoToHuman("Volkswagen", "Golf-6", human);
        humanService.addAutoToHuman("Lada", "Vesta", human);
        humanService.addAutoToHuman("Lada", "Niva", human1);
        humanService.addAutoToHuman("Lada", "Priora", human1);
        humanService.addAutoToHuman("Toyta", "Corola", human2);
        humanService.endTransaction();
    }
}
