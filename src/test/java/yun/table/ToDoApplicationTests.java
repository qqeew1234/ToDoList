package yun.table;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import todolist.list.ToDoList;
import todolist.todos.ToDo;

@SpringBootTest
class ToDoApplicationTests {

	class TodoList {

		Long id;
		String title;

		public TodoList(String title) {
			this.title = title;
		}
	}

	class Todo {

		Long id;

		String content;

		TodoList todoList;


		public Todo(String content, TodoList todoList) {
			this.content = content;
			this.todoList = todoList;
		}
	}

	@Test
	void contextLoads() {
		TodoList 리스트1 = new TodoList("집안일");
		TodoList 리스트2 = new TodoList("구매 목록");
		Todo 할일1 = new Todo("설거지하기", 리스트1);
		Todo 할일2 = new Todo("청소기", 리스트1);

		System.out.println(할일2.todoList.title); // 집안일

//		할일2.todoList.title = "fasdf";
		할일2.todoList = 리스트2;

		System.out.println(할일2.todoList.title); // 구매 목록
	}

}
