package trackUsuage;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;

/**
 * Created by Cyndaquil on 6/26/2017.
 */
public class CPU {

    public double getCurrentUsage(){
        return ((OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getSystemCpuLoad() * 100d;
    }

}
