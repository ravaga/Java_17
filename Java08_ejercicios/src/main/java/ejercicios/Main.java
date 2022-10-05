package ejercicios;

import java.util.stream.Stream;

public class Main {
	
	
	public static void main(String[] args) {		
		Stream<Foo> stream = Stream.of("1","2","3","4","5").map(Integer::valueOf).filter(i->i%2==0).map(Foo::new);
		Stream<Foo> sortedStream = Stream.of("1","4","3","2","5").map(Integer::valueOf).filter(i->i%2==0).sorted().map(Foo::new);
		Integer sum1 = Stream.of("1","2","3","4","5").map(Integer::parseInt).reduce(0, (a, b) -> a + b);
		Integer sum = Stream.of("1","2","3","4","5").map(Integer::valueOf).reduce(0, Integer::sum);
		Integer sum15 = Stream.of("1","2","3","4","5").map(Integer::valueOf).reduce(15, Integer::sum);
		
		stream.map(Foo::getId).forEach(System.out::println);
		sortedStream.map(Foo::getId).forEach(System.out::println);
				
		System.out.println("Final del ejercicio");
	}
}

