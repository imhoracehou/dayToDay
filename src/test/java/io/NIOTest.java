package io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class NIOTest {

	public static void main(String[] args) throws Exception {
		test1();
	}

	public static void test1() throws Exception {
		Path start = Paths.get("E:/00 Cache");
		FileVisitor<? super Path> visitor = new SimpleFileVisitor<Path>() {

			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
				System.out.println("正在访问：" + dir + "目录");
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				System.out.println("\t正在访问" + file + "文件");
				if (file.endsWith("Wiz.exe")) {
					System.out.println("******找到目标文件Wiz.exe******");
					return FileVisitResult.TERMINATE; // 找到了就终止
				}
				return FileVisitResult.CONTINUE; // 没找到继续找
			}
		};

		Files.walkFileTree(start, visitor);
	}
}
