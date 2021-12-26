package tip;

public enum Service {
    POOR {
        @Override
        public double tip() {
            return 0.1;
        }
    }, GOOD {
        @Override
        public double tip() {
            return 0.15;
        }
    }, GREAT {
        @Override
        public double tip(){
            return 0.18;
        }
    }, EXCELLENT {
        @Override
        public double tip() {
            return 0.2;
        }
    };

    abstract public double tip();

    public double computeTotal(double bill) {
        return (1.0 + tip()) * bill;
    }
}