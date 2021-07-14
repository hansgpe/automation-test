describe('search in catalogo',()=>{
it('search in catalog',()=>{
cy.visit('localhost:3000/shows')
cy.get('input').type('Batman')
cy.get('.btn').click();
cy.get('.card').drag('.card[2]');
cy.get('.card').contains('Batman Unlimited')
})
})