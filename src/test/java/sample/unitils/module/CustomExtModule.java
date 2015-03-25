package sample.unitils.module;

import java.lang.reflect.Method;
import java.util.Properties;

import org.unitils.core.Module;
import org.unitils.core.TestListener;

/**
 * 在①处新建自定义扩展模块CustomExtModule，实现Module接口。在②处新建自定义监听模块，继承TestListener。在③处重写（@Override
 * ）TestListener里的相关方法，完成相关扩展的功能。实现自定义扩展模块之后，剩下的工作就是在Unitils配置文件unitils.
 * properties中注册这个自定义扩展的模块： 引用 unitils.modules=…,custom unitils.module.
 * custom.className= sample.unitils.module.CustomExtModule</br>
 * http://stamen.iteye.com/blog/1480316
 *
 */
//① 实现Module接口
public class CustomExtModule implements Module {
    //② 实现获取测试监听的方法
    public TestListener getTestListener() {
        return new CustomExtListener();
    }

    //② 新建监听模块
    protected class CustomExtListener extends TestListener {
        //③ 重写 TestListener里的相关方法，完成相关扩展的功能
        @Override
        public void afterTestMethod(Object testObject, Method testMethod,
                                    Throwable testThrowable) {
        }

        @Override
        public void beforeTestMethod(Object testObject, Method testMethod) {
        }
    }

    @Override
    public void init(Properties configuration) {
        // TODO Auto-generated method stub

    }

    @Override
    public void afterInit() {
        // TODO Auto-generated method stub

    }
}