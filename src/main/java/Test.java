import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test{




    public static class Note {
        Integer first;
        String someStr;
        String someSecondStr;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;

            if (o == null || getClass() != o.getClass()) return false;

            Note note = (Note) o;

            return new EqualsBuilder()
                    .append(first, note.first)
                    .append(someStr, note.someStr)
                    .append(someSecondStr, note.someSecondStr)
                    .isEquals();
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder(17, 37)
                    .append(first)
                    .append(someStr)
                    .append(someSecondStr)
                    .toHashCode();
        }
    }

    public static <E> Map.Entry<List<E>, List<E>> findUnicValues(List<E> first, List<E> second) {



        List<E> afterFileringSecond = second.stream().filter(x -> !first.contains(x)).collect(Collectors.toList());
        List<E> afterFilteringFirst = first.stream().filter(y -> !second.contains(y)).collect(Collectors.toList());


        return null;
    }

}


