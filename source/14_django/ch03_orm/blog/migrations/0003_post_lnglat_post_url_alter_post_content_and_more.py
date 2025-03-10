# Generated by Django 5.1.6 on 2025-02-20 11:11

import blog.models
from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ("blog", "0002_post_region"),
    ]

    operations = [
        migrations.AddField(
            model_name="post",
            name="lnglat",
            field=models.CharField(
                blank=True,
                help_text="경도,위도 포맷",
                max_length=100,
                null=True,
                validators=[blog.models.lnglat_validator],
                verbose_name="경,위도",
            ),
        ),
        migrations.AddField(
            model_name="post",
            name="url",
            field=models.URLField(blank=True, null=True),
        ),
        migrations.AlterField(
            model_name="post",
            name="content",
            field=models.TextField(verbose_name="본문"),
        ),
        migrations.AlterField(
            model_name="post",
            name="region",
            field=models.CharField(
                choices=[
                    ("Europe", "유럽"),
                    ("Asia", "아시아"),
                    ("Africa", "아프리카"),
                    ("Oceania", "오세아니아"),
                    ("America", "아메리카"),
                ],
                default="Asia",
                max_length=20,
                verbose_name="지역",
            ),
        ),
        migrations.AlterField(
            model_name="post",
            name="title",
            field=models.CharField(max_length=100, verbose_name="제목"),
        ),
    ]
