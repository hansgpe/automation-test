describe('change background',()=>{
    it('background',()=>{
    cy.visit('localhost:3000/shows')
    cy.get('input').type('Batman')
    cy.get('.btn').click();
    //Change the background
    cy.get('.card').contains('Batman Unlimited')
    .parent()
    .parent()
    .invoke('css','background-color','#4a148c')
    cy.get('.card').contains('Batman Unlimited').scrollIntoView({duration: 4000});
    cy.go('back')
    cy.get('input').should('be.empty')
    })
})