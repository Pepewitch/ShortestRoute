fs.writeFile("normalgame.json",
	JSON.stringify(
		[
			{
				life : 15 ,
				node : [
					[
						{
							type : 'number',
							number : 1
						},{
							type : 'number',
							number : 1
						},{
							type : 'number',
							number : 1
						},{
							type : 'number',
							number : 1
						},{
							type : 'number',
							number : 3
						},{
							type : 'number',
							number : 4
						},{
							type : 'number',
							number : 4
						},{
							type : 'number',
							number : 1
						}
					],[
						{
							type : 'number',
							number : 1
						},{
							type : 'number',
							number : 1
						},{
							type : 'number',
							number : 1
						},{
							type : 'number',
							number : 2
						},{
							type : 'number',
							number : 5
						},{
							type : 'number',
							number : 5
						},{
							type : 'number',
							number : 5
						},{
							type : 'number',
							number : 4
						}
					],[
						{
							type : 'number',
							number : 1
						},{
							type : 'start',
							number : 1
						},{
							type : 'number',
							number : 2
						},{
							type : 'number',
							number : 1
						},{
							type : 'void',
							number : 1
						},{
							type : 'number',
							number : 8
						},{
							type : 'end',
							number : 1
						},{
							type : 'number',
							number : 1
						}
					],[
						{
							type : 'number',
							number : 1
						},{
							type : 'number',
							number : 1
						},{
							type : 'number',
							number : 1
						},{
							type : 'number',
							number : 5
						},{
							type : 'number',
							number : 2
						},{
							type : 'number',
							number : 0
						},{
							type : 'number',
							number : 1
						},{
							type : 'number',
							number : 1
						}
					],[
						{
							type : 'number',
							number : 1
						},{
							type : 'number',
							number : 1
						},{
							type : 'number',
							number : 1
						},{
							type : 'number',
							number : 3
						},{
							type : 'number',
							number : 1
						},{
							type : 'number',
							number : 1
						},{
							type : 'number',
							number : 1
						},{
							type : 'number',
							number : 1
						}
					]
				]
			}

		]
	)
	,err=>{
	if(err) throw err;
	console.log('fin')
})