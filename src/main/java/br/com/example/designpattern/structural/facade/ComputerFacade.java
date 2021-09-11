package br.com.example.designpattern.structural.facade;

/**
 * Facade:
 * Recognizable by behavioral methods which internally uses instances of different independent abstract/interface types.
 */
public class ComputerFacade {

    private Cpu cpu = null;
    private Hd hd = null;
    private Memory memory = null;

    
    public ComputerFacade(Cpu cpu, Hd hd, Memory memory) {
        super();
        this.cpu = cpu;
        this.hd = hd;
        this.memory = memory;
    }

    public void startComputer() {
        cpu.start();
        hd.read();
        memory.load();
    }
    
    public void shutdownComputer() {
        memory.free();
        hd.write();
        cpu.shutdown();
    }
}
