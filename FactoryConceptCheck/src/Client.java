/*
 * Abstract Factory example from https://sourcemaking.com/design_patterns/abstract_factory/java/1
 * with very slight enhancements.
 * 
 * The Client "main", at the end, runs the demonstration of what this factory accomplishes.
 * 
 */

// class CPU
abstract class CPU {}

// class EmberCPU
class EmberCPU extends CPU {
	@Override
	public String toString() {
		return "I am an EmberCPU";
	}
}

// class EnginolaCPU
class EnginolaCPU extends CPU {
	@Override
	public String toString() {
		return "I am an EnginolaCPU";
	}
}

// class MMU
abstract class MMU {}

// class EmberMMU
class EmberMMU extends MMU {
	@Override
	public String toString() {
		return "I am an EmberMMU";
	}
}

// class EnginolaMMU
class EnginolaMMU extends MMU {
	@Override
	public String toString() {
		return "I am an EnginolaMMU";
	}	
}

// class EmberFactory
class EmberToolkit extends AbstractFactory {
    @Override
    public CPU createCPU() {
        return new EmberCPU();
    }

    @Override
    public MMU createMMU() {
        return new EmberMMU();
    }
}

// class EnginolaFactory
class EnginolaToolkit extends AbstractFactory {
    @Override
    public CPU createCPU() {
        return new EnginolaCPU();
    }

    @Override
    public MMU createMMU() {
        return new EnginolaMMU();
    }
}

enum Architecture {
    ENGINOLA, EMBER
}

abstract class AbstractFactory {
    private static final EmberToolkit EMBER_TOOLKIT = new EmberToolkit();
    private static final EnginolaToolkit ENGINOLA_TOOLKIT = new EnginolaToolkit();

    // Returns a concrete factory object that is an instance of the
    // concrete factory class appropriate for the given architecture.
    static AbstractFactory getFactory(Architecture architecture) {
        AbstractFactory factory = null;
        switch (architecture) {
            case ENGINOLA:
                factory = ENGINOLA_TOOLKIT;
                break;
            case EMBER:
                factory = EMBER_TOOLKIT;
                break;
        }
        return factory;
    }

    public abstract CPU createCPU();

    public abstract MMU createMMU();
}

// This is a test run, which in just one line says "We're doing EMBER this time."  As a result,
// all the individual pieces are "Ember" parts, as proven by the console printout.

public class Client {
    public static void main(String[] args) {
        AbstractFactory factory = AbstractFactory.getFactory(Architecture.EMBER);
        CPU cpu = factory.createCPU();
        MMU mmu = factory.createMMU();
        System.out.println("Created EMBER CPU.  Components are cpu: '"+cpu+"' and mmu: '"+mmu+"'.");
    }
}
