document.addEventListener('DOMContentLoaded', () => {
    window.scrollTo({top: 0, behavior: 'smooth'});
})
const addForm = document.getElementById('addForm');
const updateForm = document.getElementById('updateForm');
const updateButtons = document.querySelectorAll('.update-btn');
const showUpdateForm = (demandeDescription) => {
    document.getElementById('UpdateDescriptionId').value = demandeDescription;
    if(updateForm.classList.contains('hidden')) {
        console.log('hidden');
        addForm.classList.add('hidden');
        setTimeout(() => {
            addForm.style.display = 'none';
            updateForm.classList.remove('hidden');
            updateForm.classList.add('shown');
            window.scrollTo({top: 0, behavior: 'smooth'});
        }, 600);
    } else{
        window.scrollTo({top: 0, behavior: 'smooth'});
    }
}