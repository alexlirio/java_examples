package br.com.example.designpattern.structural.facade;

public class ComputerFacadeTest {

    public static void main(String[] args) {
        Cpu cpu = new CpuImp();
        Hd hd = new HdImp();
        Memory memory = new MemoryImp();
        
        ComputerFacade computerFacade = new ComputerFacade(cpu, hd, memory);
        computerFacade.startComputer();
        computerFacade.shutdownComputer();
    }
}
