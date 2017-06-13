package test.PinCPU;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;
import java.text.DecimalFormat;
import java.text.NumberFormat;


import static test.PinCPU.RunPinCPU.SECOND_VARIABLE;
import static test.PinCPU.RunPinCPU.chartCPU;
import static test.PinCPU.RunPinCPU.chartRAM;

/**
 * Created by Cyndaquil on 6/12/2017.
 * Updates the Load chart
 */
public class ChartUpdateThread implements Runnable {
    private final long TOTALRAM = ((OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getTotalPhysicalMemorySize();
    private volatile boolean go = true;
    private Thread starter;

    ChartUpdateThread(Thread currentThread) {
        this.starter = currentThread;
    }

    @Override
    public void run() {
        NumberFormat cpu = new DecimalFormat("0.00");
        NumberFormat ram = new DecimalFormat("0.0");
        while (go) {
            if (!starter.isAlive()) {
                go = false;
            }
            try {
                if (RunPinCPU.cpuLoadValue.doubleValue() != 0d) {
                    chartCPU[chartCPU.length-2].setYValue(RunPinCPU.cpuLoadValue.intValue());
                    chartRAM[chartRAM.length-2].setYValue(RunPinCPU.ramLoadValue.intValue());
                }

                for (int i = 0; i < chartCPU.length-2; i++) {
                    RunPinCPU.chartCPU[i].setYValue(RunPinCPU.chartCPU[i + 1].getYValue());
                    chartRAM[i].setYValue(chartRAM[i + 1].getYValue());
                }


                long freeRam = ((OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getFreePhysicalMemorySize();
                RunPinCPU.ramLoadValue.setValue((double)(TOTALRAM- freeRam)/TOTALRAM*100d);


                double cpuPercent = ((OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getSystemCpuLoad() * 100d;
                RunPinCPU.cpuLoadValue.setValue(cpuPercent);

                RunPinCPU.cpuCurrentValue.setValue(String.valueOf(cpu.format(cpuPercent)+"%"));
                RunPinCPU.ramCurrentValue.setValue(ram.format(Double.valueOf((double) (TOTALRAM- freeRam)/1024d/1024d/1024d))+"GB");
                Thread.sleep(1000/SECOND_VARIABLE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
