public interface IntSequence {

  boolean hasNext();

  int next();

  public static IntSequence of(int ...v){
    IntSequence intSequence = new IntSequence() {
        int i = 0;
        public boolean hasNext() {
            if (i < v.length) {
                return true;
            } return false;
        }
        public int next() {
            if (i < v.length) {
                i++;
                return v[i - 1];
            } else {
                throw new ArrayIndexOutOfBoundsException("Such element not found");
            }
        }
    };
    return intSequence;
  }

  public static IntSequence constant(int v) {
    IntSequence intSequence = new IntSequence() {
        public boolean hasNext() {
            return true;
        }
        public int next() {
            return v;
        }
    };
    return intSequence;
  }
}