//репозиторій працює з об'єктами бази даних, які містяться поза оперативною пам'яттю в момент
// виконання запиту. йому передається критерій, за яким він обирає один або кілька об'єктів
// (бо всі не потрібні!)

package com.prometheus.dbdisplay.repository;

import com.prometheus.dbdisplay.domain.Admin;
import org.springframework.data.repository.CrudRepository;

//інтерфейс, який забезпечує основні операції по пошуку, зберіганню, видаленню даних
public interface AdminRepo extends CrudRepository<Admin, Long> {

}
