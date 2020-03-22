//репозиторій працює з об'єктами бази даних, які містяться поза оперативною пам'яттю в момент
// виконання запиту. йому передається критерій, за яким він обирає один або кілька об'єктів
// (бо всі не потрібні!)

package com.prometheus.dbdisplay.repository;

import com.prometheus.dbdisplay.domain.Program;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

// інтерфейс, який забезпечує основні операції по пошуку, зберіганню, видаленню даних
public interface ProgramRepo extends CrudRepository<Program, Long> {
  // цей метод формується за принципом findBy + назва параметра, за яким буде здійснюватися
  // пошук (фільтрація)
  List<Program> findByProgramType(String programType);

}
