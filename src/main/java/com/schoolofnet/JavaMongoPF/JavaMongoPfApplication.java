package com.schoolofnet.JavaMongoPF;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class JavaMongoPfApplication implements CommandLineRunner {
	@Autowired
	private TaskRepository taskRepository;
	private Scanner reader;

	public static void main(String[] args) {
		SpringApplication.run(JavaMongoPfApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.reader = new Scanner(System.in);

		Integer operation = 0;

		do {
			System.out.println("Choose option below");
			System.out.println("-------------------\n");
			System.out.println("1 - Create task");
			System.out.println("2 - List tasks");
			System.out.println("3 - Delete task by name");
			System.out.println("4 - Update task by name");
			System.out.println("0 - exit");

			operation = this.reader.nextInt();
			this.reader.nextLine();

			switch (operation) {
				case 1: create(); break;
				case 2: list(); break;
				case 3: delete(); break;
				case 4: update(); break;
			}
		} while (operation != 0);
	}

	public void create() {
		System.out.println("Task name: ");
		String name = this.reader.nextLine();
		taskRepository.insert(new Task(name));
	}

	public void list() {
		List<Task> tasks = taskRepository.findAll();
		for (Task task: tasks) {
			System.out.println(task.getName());
		}
	}

	public void delete() {
		System.out.println("Task name: ");
		String name = this.reader.nextLine();
		Task task = taskRepository.findByName(name);
		taskRepository.delete(task);
		System.out.println("Deleted!");
	}

	public void update() {
		System.out.println("Task name: ");
		String name = this.reader.nextLine();
		Task task = taskRepository.findByName(name);

		System.out.println("New name (" + name + "): ");
		String newName = this.reader.nextLine();
		task.setName(newName);
		taskRepository.save(task);
	}
}
