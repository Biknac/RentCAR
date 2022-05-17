	function DeleteOperators(){
			var id = document.getElementById("idOper").value;
	
			fetch('http://localhost:8080//RentCAR_CS/OrderListServlet',{
				method: 'DELETE',
				body: JSON.stringify({
					id,
					status: 'DELETE',
				}),
				headers: {
				    'Content-type': 'application/json; charset=UTF-8',
				},
			});
		}