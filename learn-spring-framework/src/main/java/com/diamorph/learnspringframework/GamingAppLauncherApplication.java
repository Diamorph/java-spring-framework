package com.diamorph.learnspringframework;

import com.diamorph.learnspringframework.game.GameRunner;
import com.diamorph.learnspringframework.game.PacmanGame;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.diamorph.learnspringframework.game")
public class GamingAppLauncherApplication {

    public static void main(String[] args) {
        try(
            AnnotationConfigApplicationContext context =
                    new AnnotationConfigApplicationContext
                            (GamingAppLauncherApplication.class)) {
            GameRunner gameRunner = context.getBean(GameRunner.class);
//            PacmanGame pacmanGame = (PacmanGame) context.getBean("pacmanGame");
//            gameRunner.setGame(pacmanGame);
            gameRunner.run();

//            context.getBean(GamingConsole.class).up();
//            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
//            ((GamingConsole) context.getBean("pacmanGame")).left();
//            context.getBean(GameRunner.class).run();
        }
    }
}
