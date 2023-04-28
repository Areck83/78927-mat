const consumirVicio = () => {
    axios
      //.get('https://reqres.in/api/users')
      .get('https://swapi.dev/api/planets/1/')
      .then(response => {
        const planetas = response.data.data
        console.log(`GET list users`, planetas)
      })
      .catch(error => console.error(error))
  }
  
  consumirVicio()

  const crearLi = planetas => {
    const li = document.createElement('li')
    // add user details to `li`
    li.textContent = `${planetas.name}: ${planetas.diameter} ${planetas.climate}`
    return li
  }
  
  const appendToDOM = planetas => {
    const ul = document.querySelector('ul')

    planetas.map(planeta => {
      ul.appendChild(crearLi(planeta))
    })
  }
  
  const traerPlanetas = () => {
    axios
      .get('https://swapi.dev/api/planets/')
      .then(response => {
        const planetas = response.data.results
        console.log(`Obtener lista de planetas`, planetas)
        // append to DOM
        appendToDOM(planetas)
      })
      .catch(error => console.error(error))
  }
  
  traerPlanetas()