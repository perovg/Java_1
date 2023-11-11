import java.util.Comparator;

public class Employee implements Comparable<Employee> {

  private String name;
  private String surname;
  private int age;
  private String city;
  private int salary;

  public Employee(String name, String surname, int age, String city, int salary) {
    this.name = name;
    this.surname = surname;
    this.age = age;
    this.city = city;
    this.salary = salary;
  }

  public Employee(String name, int age) {
    this(name, "", age, "",  0);
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public String getCity() {
    return city;
  }

  public int getAge() {
    return age;
  }

  public int getSalary() {
    return salary;
  }

  public static final Comparator<Employee> AGE_SALARY_COMPARATOR = new AgeSalaryComparator();
  public static final Comparator<Employee> PASSPORT_COMPARATOR = new PassportComparator();
  public static final Comparator<Employee> FULL_COMPARATOR = new FullComparator();

  @Override
  public int compareTo(Employee first) {
    if (this.name.compareToIgnoreCase(first.getName()) > 0) {
      return 1;
    } else if (this.name.compareToIgnoreCase(first.getName()) < 0) {
      return -1;
    } else {
      if (this.age > first.getAge()) {
        return 1;
      } else if (this.age < first.getAge()) {
        return -1;
      } else {
        return 0;
      }
    }
  }

  public static class AgeSalaryComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee first, Employee second) {
      if (first.getAge() > second.getAge()) {
        return 1;
      } else if (first.getAge() < second.getAge()) {
        return -1;
      } else {
        if (first.getSalary() > second.getSalary()) {
          return 1;
        } else if (first.getSalary() < second.getSalary()) {
          return -1;
        } else {
          return 0;
        }
      }
    }
  }

  public static class PassportComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee first, Employee second) {
      if (first.getName().compareTo(second.getName()) > 0 || (first.getName().equals("") && !second.getName().equals(""))) {
        return -1;
      } else if (first.getName().compareTo(second.getName()) < 0  || (!first.getName().equals("") && second.getName().equals(""))) {
        return 1;
      } else {
        if (first.getSurname().compareTo(second.getSurname()) > 0 || (first.getSurname().equals("") && !second.getSurname().equals(""))) {
          return -1;
        } else if (first.getSurname().compareTo(second.getSurname()) < 0 || (!first.getSurname().equals("") && second.getSurname().equals(""))) {
          return 1;
        } else {
          if (first.getCity().compareTo(second.getCity()) > 0 || (!first.getCity().equals("") && second.getCity().equals(""))) {
            return -1;
          } else if (first.getCity().compareTo(second.getCity()) < 0 || (first.getCity().equals("") && !second.getCity().equals(""))) {
            return 1;
          } else {
            return 0;
          }
        }
      }
    }
  }

  public static class FullComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee first, Employee second) {
      if (first.getName().compareTo(second.getName()) > 0 || (first.getName().equals("") && !second.getName().equals(""))) {
        return -1;
      } else if (first.getName().compareTo(second.getName()) < 0  || (!first.getName().equals("") && second.getName().equals(""))) {
        return 1;
      } else {
        if (first.getSurname().compareTo(second.getSurname()) > 0 || (first.getSurname().equals("") && !second.getSurname().equals(""))) {
          return -1;
        } else if (first.getSurname().compareTo(second.getSurname()) < 0 || (!first.getSurname().equals("") && second.getSurname().equals(""))) {
          return 1;
        } else {
          if (first.getCity().compareTo(second.getCity()) > 0 || (first.getCity().equals("") && !second.getCity().equals(""))) {
            return -1;
          } else if (first.getCity().compareTo(second.getCity()) < 0 || (!first.getCity().equals("") && second.getCity().equals(""))) {
            return 1;
          } else {
            if (first.getAge() > second.getAge()) {
              return 1;
            } else if (first.getAge() < second.getAge()) {
              return -1;
            } else {
              if (first.getSalary() > second.getSalary()) {
                return 1;
              } else if (first.getSalary() < second.getSalary()) {
                return -1;
              } else {
                return 0;
              }
            }
          }
        }
      }
    }
  }
}