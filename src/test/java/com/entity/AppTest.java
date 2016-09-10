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
        Human human = humanService.addHuman("Иван", "Петрович", "Васильев","г. Пермь");
        Human human1 = humanService.addHuman("Андрей", "Алексеевич", "Сидоров", "г. Москва");
        Human human2 = humanService.addHuman("Роман", "Александрович", "Никулин", "г. Самара");
        humanService.addAutoToHuman("Volkswagen", "Golf-6", human);
        humanService.addAutoToHuman("Lada", "Vesta", human);
        humanService.addAutoToHuman("Lada", "Niva", human1);
        humanService.addAutoToHuman("Lada", "Priora", human1);
        humanService.addAutoToHuman("Toyta", "Corola", human2);
        humanService.endTransaction();
    }
}
