package com.example.todolistapp

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolistapp.ui.theme.TodoListAppTheme
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun TodoListsCard(todo: Todo){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(
                16.dp,
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = SimpleDateFormat(
                    "HH:mm:aa, dd/mm",
                    Locale.ENGLISH
                ).format(todo.createdAt),
                fontSize = 12.sp,
                color = Color.LightGray,
            )
            Text(
                text = todo.name,
                fontSize = 20.sp,
                color = Color.White
            )
        }
        
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_delete_24),
                contentDescription = "Delete",
                tint = Color.White
            )
        }
    }
}

@Composable
fun TodosLists(todos: List<Todo>){
    LazyColumn(
        content = {
            itemsIndexed(todos){index: Int, item: Todo ->
                TodoListsCard(todo = item)
            }
        }

    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TodoListPage(){
    Column(modifier = Modifier
        .fillMaxHeight()
        .padding(8.dp)
    ) {
        TodosLists(todos = SampleData.sampleTodos)
    }
}



@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable

fun PreviewTodosLists(){
    TodoListAppTheme {
        TodoListPage()
    }
}