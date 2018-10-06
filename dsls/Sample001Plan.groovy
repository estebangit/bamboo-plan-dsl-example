import dsls.utilities.MyUtility
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

final Logger log = LogManager.getLogger()
log.info("Sample001 ...")

// and reference it in the plan DSL
project(key: 'SMPL001', name: 'Sample 001 project') {

    log.info("... add plan 001")
    def plan = plan(key: 'SMPL001PLAN', name: '001 plan') {
        log.info("... add deploy project 001")
        deploymentProject(name: '001 deployment project') {
            environment(name: 'CTLQ') {
            }
            environment(name: 'PROD') {
            }
        }
    }

    log.info("... add stage 1")
    def stage1 = plan.stage(name: '001 stage1') {
        //description '001 stage 1'
        job(key: 'BUILD', name: 'Example job') {
            def myTasks = tasks {
            }
            MyUtility.addGradleTest(myTasks)
        }
    }
    MyUtility.addStageDescription(stage1, '001 stage 1')

    log.info("... add stage 2")
    def stage2 = plan.stage(name: '001 stage2') {
        //description '001 stage 2'
        job(key: 'BUILD', name: 'Example job') {
            def myTasks = tasks {
            }
            MyUtility.addGradleTest(myTasks)
        }
    }
    MyUtility.addStageDescription(stage2, '001 stage 2')

}
log.info("Sample001 !!!")
