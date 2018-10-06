package dsls.utilities

import ch.mibex.bamboo.plandsl.dsl.Stage
import ch.mibex.bamboo.plandsl.dsl.tasks.Tasks

class MyUtility {

    static void addGradleTest(Tasks tasks) {
        tasks.with {
            script() {
                description 'run tests'
                inline {
                    interpreter ScriptInterpreter.LEGACY_SH_BAT
                    scriptBody './gradlew test'
                }
            }
        }
    }

    static void addStageDescription(Stage stage, String desc) {
        stage.with {
            description desc
        }
    }

}
