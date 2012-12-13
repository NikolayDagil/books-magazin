<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="bookSave" method="post">
			<table>
				<tr>
					<td>Author</td>
					<td><input type="text" name="author"></td>
				</tr>
				<tr>
					<td>Title</td>
					<td><input type="text" name="title"></td>
				</tr>
				<tr>
					<td>Number Page</td>
					<td><input type="number" name="numberPage"></td>
				</tr>
				<tr>
					<td>Imprint Date</td>
					<td><input type="date" name="imprintDate"></td>
				</tr>
				<tr>
					<td>Price</td>
					<td><input type="number" name="price"></td>
				</tr>
				<tr>
					<td>Rating</td>
					<td><input type="number" name="rating"></td>
				</tr>
				<tr>
					<td>Discounts</td>
					<td><input type="number" name="discounts"></td>
				</tr>
				<tr>
					<td>Status</td>
					<td><input type="checkbox" name="status"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Sig in"></td>
				</tr>
			</table>
		</form>
	</body>
</html>